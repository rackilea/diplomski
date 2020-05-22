class Dog {
    private int size;
    private String breed;

    public Dog(){
    }

    public Dog(String breed, int size){
        this.breed = breed;
        this.size = size;
    }

    public void setbreed(String breed) {
        this.breed = breed;
    }
    public void setsize(int size) {
        this.size = size;
    }
    public int getsize() {
        return size;
    }
    public String getbreed() {
        return breed;
    }
    public void bark() {
        System.out.println("Bark!");
    }
}