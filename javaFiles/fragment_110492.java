class Holder
{
    private static Holder instance = null;
    private List<String> itemArray;
    private Holder(){
       itemArray = new ArrayList<>();
    }

    public static Holder getInstance(){
        if (instance == null)
            instance = new Holder();
        return instance;
    }

    public List<String> getItemArray(){
        return new ArrayList<>(this.itemArray);
    }

    public void addItemToArray(String item){
            this.itemArray.add(item);
    }
}