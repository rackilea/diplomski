while (input.hasNext()) 
{
    String[] line = input.nextLine().replace(",", "").split("\\s+");
    String age = line[0];
    String lastName = line[1];
    String firstName = "";
    //take the rest of the input and add it to the last name
    for(int i = 2; 2 < line.length && i < line.length; i++)
        firstName += line[i] + " ";

    System.out.println(firstName + lastName + " " + age);

}