package com.the93rd.android.bookcatalog;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.Toast;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
    Button mAddBook;
    public ArrayList<Book> books;
    public ListView listView;
    public BookListViewAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array List of Book objects
        books = new ArrayList<>();

        books.add(new Book("J.K. Rolling", "Harry Potter and The Sorcerers Stone", 8,
                "0439708184", "Yes"));
        books.add(new Book("Eoin Colfer", "The Artic Accident", 5,
                "1423124529", "Yes"));
        books.add(new Book("George S. Clason", "The Richest Man in Babylon", 9,
                "1505339111", "No"));
        books.add(new Book("Khaled Hosseini", "The Kite Runner", 10,
                "159463193X", "Yes"));
        books.add(new Book("Daniel Keyes", "Flowers For Algernon", 8,
                "0156030306", "No"));

        listView = (ListView) findViewById(R.id.list);
        bookAdapter = new BookListViewAdapter(this, books);

        listView.setAdapter(bookAdapter);


        //Open BookDetails Activity to Display more book information
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get ArrayList element
                Book book = books.get(position);

                //Get fields for current Book element
                String passAuthor = book.getAuthor();
                String passTitle = book.getTitle();
                int passRating = book.getRating();
                String passIsbn = book.getIsbn();
                String passSeries = book.getSeries();

                Toast.makeText(MainActivity.this, book.getAuthor(), Toast.LENGTH_SHORT).show();

                //Pass Extras for Book element to BookDetails Activity
                Intent openDetail = new Intent(MainActivity.this, BookDetails.class);
                openDetail.putExtra("Author", passAuthor);
                openDetail.putExtra("Title", passTitle);
                openDetail.putExtra("Rating", passRating);
                openDetail.putExtra("Isbn", passIsbn);
                openDetail.putExtra("Series", passSeries);
                startActivity(openDetail);
            }
        });

        //Open AddBook Activity
        mAddBook = (Button) findViewById(R.id.add_book);
        mAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent addBook = new Intent(MainActivity.this, AddBook.class);
                int requestCode = 1;
                startActivityForResult(addBook, requestCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String addAuthor = data.getStringExtra("addAuthor");
        String addTitle = data.getStringExtra("addTitle");
        String addRating = data.getStringExtra("addRating");
        String addIsbn = data.getStringExtra("addIsbn");
        String addSeries = data.getStringExtra("addSeries");

        if(addAuthor != null){
            //Add variables from AddBook activity to new Book object
            books.add(new Book(addAuthor, addTitle, 5, addIsbn, addSeries));
            bookAdapter.notifyDataSetChanged();
        }

    }
}