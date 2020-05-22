public class Dog extends Animal {

    private String breed;

    public Dog() {

    }

    public Dog(String name, String breed) {
        setName(name);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

public class Cat extends Animal {

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public Cat() {}

    public Cat(String name, String favoriteToy) {
        setName(name);
        setFavoriteToy(favoriteToy);
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    private String favoriteToy;

}