import java.util.ArrayList;
    import java.util.List;

    public class Main {
        public static void main(String[] args) {
            String[] petInfo = {"Spot, dog, 2, Joey", "Kip, dog, 3, Jack", "Snuffles, cat, 1, Jane" , "Franklin, turtle, 4, Arthur"};
            List<Pet> pets = new ArrayList<Pet>();
            for (String singlePetInfo : petInfo) {
                pets.add(getPetFromString(singlePetInfo));
            }

            pets.forEach(System.out::println);
        }

        private static Pet getPetFromString(String petDescription){
            String[] split = petDescription.split(", ");
            return new Pet(split[0], split[1], Integer.parseInt(split[2]), split[3]);
        }
    }