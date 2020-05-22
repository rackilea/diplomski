public class MainActivity extends AppCompatActivity {

    static ArrayList<Bitmap> newImage;
    ArrayList<String> nameList;
    ArrayList<String> name2List;
    ArrayList<String> name3List;
    ArrayAdapter<String> arrayadpater;
    ListView listView;

    Button addbutton; //<<<< Instead of menu for my convenience
    //<<<<<<<<<< Code Commented out for convenience of using button >>>>>>>>>
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_new, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override //Menüyü seçersek ne olacak onu belirler.
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_new) {

            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            intent.putExtra("info", "new"); //Bu satırda amaç eğer yeni bir resimmi yoksa eski resimmi görentülenmek isteniyor onu anlamak
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview); //<<<< CHANGED as declared as class variable

        //<<<<<<<<<< Code below for the conveince of using a button instead of Menu >>>>>>>>>>
        addbutton = (Button) findViewById(R.id.addnew);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("info", "new"); //Bu satırda amaç eğer yeni bir resimmi yoksa eski resimmi görentülenmek isteniyor onu anlamak
                startActivity(intent);
            }
        });
        //<<<<<<<<<< End of code for Button handling >>>>>>>>>>

        setupListView();

        //<<<<<<<<<< NOTE commented out Code >>>>>>>>>>
        /*
        //Databaseden çektiğimiz dataları kaydedeceğimiz bir arraylist oluşturalım ve listview ile bağlayalım
        final ArrayList<String> newName = new ArrayList<String>();
        final ArrayList<String> newName2 = new ArrayList<String>();
        final ArrayList<String> newName3 = new ArrayList<String>();
        newImage = new ArrayList<Bitmap>();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,newName);
        listView.setAdapter(arrayAdapter);

        //uygulama ilk açıldığında database'de kayıtlı bir şey varmı bakmasını istiyoruz aşağıdaki aşamalarda

        try {

            Main2Activity.database = this.openOrCreateDatabase("Yeni", MODE_PRIVATE, null);
            Main2Activity.database.execSQL("CREATE TABLE IF NOT EXISTS yeni (name VARCHAR, name2 VARCHAR, name3 VARCHAR, image BLOB)");

            Cursor cursor = Main2Activity.database.rawQuery("SELECT * FROM yeni", null); //Data çekmek için cursoru kullanıyoruz

            int nameIx = cursor.getColumnIndex("name");
            int name2Ix = cursor.getColumnIndex("name2");
            int name3Ix = cursor.getColumnIndex("name3");
            int imageIx = cursor.getColumnIndex("image");

            cursor.moveToFirst();

            while (cursor != null) {

                newName.add(cursor.getString(nameIx)); //Kullanıcının girdği ismi newName'in içine ekle
                newName2.add(cursor.getString(name2Ix));
                newName3.add(cursor.getString(name3Ix));

                byte[] byteArray = cursor.getBlob((imageIx));
                Bitmap image = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
                newImage.add(image); //newImage'in içine ekle diyoruz

                cursor.moveToNext();

                arrayAdapter.notifyDataSetChanged();//Eğer bir datayı değiştirdiysek hemen güncelleyen bir konut
            }

        } catch (Exception e) {
        }
        */
    }
    //<<<< ADDED to handle return from child >>>>
    @Override
    public void onResume() {
        super.onResume();
        setupListView();
    }

    //<<<< ADDED to utilise a single refreshable ListView
    private void setupListView() {
        getListsFromDatabase();
        if (arrayadpater == null) {
            arrayadpater = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameList);
            listView.setAdapter(arrayadpater);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent (getApplicationContext(), Main2Activity.class);
                    intent.putExtra("info", "old");
                    intent.putExtra("name", nameList.get(position));
                    intent.putExtra("name2", name2List.get(position));
                    intent.putExtra("name3", name3List.get(position));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        } else {
            arrayadpater.notifyDataSetChanged();
        }
    }

    //<<<< Added to build/rebuild the Arraylist's used by the ListView
    private void getListsFromDatabase() {
        // Get the database (and set the databse for Main2Acticity)
        SQLiteDatabase db = openOrCreateDatabase(
                "Yeni",
                MODE_PRIVATE,
                null
        );
        db.execSQL("CREATE TABLE IF NOT EXISTS yeni (name VARCHAR, name2 VARCHAR, name3 VARCHAR, image BLOB)");
        Main2Activity.database = db;

        // Initialise or clear the array lists
        if (nameList == null) {
            nameList = new ArrayList<>();
        } else {
            nameList.clear();
        }
        if (name2List == null) {
            name2List = new ArrayList<>();
        } else {
            name2List.clear();
        }
        if (name3List == null) {
            name3List = new ArrayList<>();
        } else {
            name3List.clear();
        }
        if (newImage == null) {
            newImage = new ArrayList<>();
        } else {
            newImage.clear();
        }
        // get the
        Cursor cursor = db.query("yeni",
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext()) {
            nameList.add(cursor.getString(cursor.getColumnIndex("name")));
            name2List.add(cursor.getString(cursor.getColumnIndex("name2")));
            name3List.add(cursor.getString(cursor.getColumnIndex("name3")));
            byte[] b = cursor.getBlob(cursor.getColumnIndex("image"));
            Bitmap bmp = BitmapFactory.decodeByteArray(b,0,b.length);
            newImage.add(bmp);
        }
        cursor.close();
    }
}