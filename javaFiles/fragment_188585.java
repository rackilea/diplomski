import java.util.Comparator;

public class AgeComparator implements Comparator<Animal>{
    @Override
    public int compare(Animal animal1, Animal animal2) {
        if(animal1.getAge() < animal2.getAge()){
            return 1;
        } else if (animal1.getAge() > animal2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

}