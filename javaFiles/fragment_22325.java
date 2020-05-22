public class Animal {

    public String type;
}

public class Zoo {

    public AnimalSummary calculateAnimalTypeLegs(Animal animal, AnimalSummary animalSummary){

        if (animal.type.equals("Bear"))
            animalSummary.setTotalLegs(animalSummary.getTotalLegs()+4);
        if (animal.type.equals("Human"))
            animalSummary.setTotalLegs(animalSummary.getTotalLegs()+2);

        return animalSummary;
    }
}

public class AnimalSummary {

    public int getTotalLegs() {
        return totalLegs;
    }

    public void setTotalLegs(int totalLegs) {
        this.totalLegs = totalLegs;
    }

    private int totalLegs;
}

public class Main {

    public static void main(String[] args) throws Exception {
        Animal bear = new Animal();
        bear.type = "Bear";

        Animal human = new Animal();
        human.type = "Human";
        List<Animal> animals = Arrays.asList(bear, human);

        AnimalSummary animalSummary = new AnimalSummary();
        for (Animal animal : animals){
            animalSummary = new Zoo().calculateAnimalTypeLegs(animal, animalSummary);
        }

        System.out.println(animalSummary.getTotalLegs()); 
    }
}