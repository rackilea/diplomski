public class Shelves {
    private String name;
    private ArrayList<Book> ph = new ArrayList<Book>();

    public Shelves(String name){        
        this.name = name;
        this.ph = new ArrayList<Book>();
    }
    public void displayShelf(){
        System.out.println("Shelve:" +this.name);
        System.out.println("It has following books :");
        for(int i = 0; i < this.ph.size(); i++){
           System.out.println(this.ph.get(i).getTitle());
        }
    }
    public void addBook(Book book){
         ph.add(book);
    }
}