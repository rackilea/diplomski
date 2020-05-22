public class DogItem {
    private static DogItem[] dogListArray = new DogItem[100];
    private static int numItems = 0;

    private String name;
    private String breed;
    private String weight;
    private String owner1;
    private String owner2;

    public DogItem(String name, String breed, String weight, String owner1, String owner2) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.owner1 = owner1;
        this.owner2 = owner2;
    }

    public static void add(DogItem dogItem) {
        dogListArray[numItems++] = dogItem;
    }

    public static DogItem searchForItem(String name) {
        DogItem dogItem = null;
        for (DogItem result : dogListArray) {
            if (result != null) {
                if (result.getName() == name) {
                    dogItem = result;
                }
            }
        }
        return dogItem;
    }

    @Override
    public String toString() {
        String result = name + ", " + breed + ", " + weight + ", " + owner1 + " " + owner2;
        return result;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getOwner1() {
        return owner1;
    }
    public void setOwner1(String owner1) {
        this.owner1 = owner1;
    }
    public String getOwner2() {
        return owner2;
    }
    public void setOwner2(String owner2) {
        this.owner2 = owner2;
    }
}