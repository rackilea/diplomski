public class MainActivity extends ListActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MySQLiteHelper db = new MySQLiteHelper(this); 
    /**
     * CRUD Operations
     * */
    // add Books
    Log.d("Inserting: ", "Inserting all Books..");
    db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));   
    db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));       
    db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
   //Reading and getting all books
    Log.d("Reading: ", "Reading all Books.."); 
    List<Book> list = db.getAllBooks();
 ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,
    android.R.layout.simple_list_item_1, values);
setListAdapter(adapter); 
    for (Book cn:list) {
        String log = "Id: "+cn.getId()+" ,Title: " + cn.getTitle() + " ,Author: " + cn.getAuthor() ;
            // Writing Contacts to log
    Log.d("Name: ", log);
   // delete one book
   //db.deleteBook(list.get(0));

}