public class MergeLines
{
    // Animal model object:
    // Note: This can placed in another file called Animal.java and
    // made into a public, non-static class, but I created it in this
    // manner for purpose of having a and self-containted example.
    private static class Animal
    {
        private String name;
        private String description;

        public Animal(String name)
        {
            this.name = name;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        @Override
        public String toString ()
        {
            return "[" + name + "," + description + "]";
        }
    }

    public static void main (String[] args)
    {
        // this list will hold our animals
        List<Animal> animals = new ArrayList<Animal>();

        try (BufferedReader br = new BufferedReader(new FileReader("speciesFile.txt")))
        {
            String line;
            String description = "";
            Animal animal = null;
            while ((line = br.readLine()) != null)
            {
                if (line.contains(">"))
                {
                    // check if we had a previous animal
                    if (description.length() > 0 && animal != null)
                    {
                        // set the description and add to the list
                        animal.setDescription(description);
                        animals.add(animal);

                        // reset for the next animal
                        description = "";
                        animal = null;
                    }

                    // Note: you had split("|") but that is incorrect 
                    // since the '|' character means OR in regex.
                    String[] array = line.split("\\|");
                    if (array.length == 2)
                    {
                        String name = array[1];

                        // create the animal
                        animal = new Animal(name);
                    }
                }
                else
                {
                    description = description + " " + line;
                }
            }

            // add the last animal to the list
            if (animal != null)
            {
                animal.setDescription(description);
                animals.add(animal);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // finally, print them out.
        System.out.println("Animals = " + animals);
    }
}