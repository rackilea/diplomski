private static ArrayList<String> owners;
    private static ArrayList<DogItem> dogsList;
    public DogItem(String name, String breed, String weight, String owner) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.owners.add(owner);
    }
    public void init() {
        owners = new ArrayList<String>();
        dogsList = new ArrayList<DogItem>();
    }
    public void addDog(DogItem dogItem) {
        dogsList.add(dogItem);
    }
    public DogItem searchForItem(String name) {
        DogItem dogItem = null;
        for (DogItem result : dogsList) {
            if (result != null) {
                if (result.getName() == name) {
                    dogItem = result;
                }
            }
        }
        return dogItem;
    }
    public void addOwner(String owner) {
        owners.add(owner);
    }
    public String getOwner() {
        return owners.get(owners.size() - 1);
    }