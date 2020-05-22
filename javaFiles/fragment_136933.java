public class FrmSaludo extends Activity {
    private String isbn;
    private OtherParse.Book libro;
    public TextView txtSaludo;
    private OtherParse.Book resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_saludo);

        // Localizar los controles
        txtSaludo = (TextView) findViewById(R.id.TxtSaludo);

        // Recuperamos la información pasada en el intent
        //Bundle bundle = this.getIntent().getExtras();
        //this.isbn = bundle.getString("ISBN");
        this.isbn = "0345391802";

        Buscar();


        /*
         * OtherParse otherparse= new OtherParse(isbn);
         * txtSaludo.setText("Hola " + otherparse.getResult());
         */
    }

    private class SearchIsbnTask extends AsyncTask<String, Integer, Boolean> {


        @Override
        protected Boolean doInBackground(String... params) {
            /*
             * ParseJson parse= new ParseJson(params[0]); libro = parse.Parse();
             */
            try{
                OtherParse otherParse = new OtherParse(params[0]);
                resultado = otherParse.getBook();
                Log.v("TEST", "book ="+resultado.toString());
            }catch (Exception e){

                Log.e("BACKGROUND", "Error ejecutando hilo" + e);

            }
            return true;

        }
        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            Log.v("TEST", "volviendo a hilo principal");

            if (result) {
                txtSaludo.setText("Hola " + resultado.getTitle() + " author: " + resultado.getAuthors());
            }

        }

    }

    public void Buscar() {

        // Carga del XML mediante la tarea asíncrona
        SearchIsbnTask tarea = new SearchIsbnTask();

        tarea.execute(isbn);
    }
}


   class OtherParse {

    private String url;
    private JSONObject jsonObject;
    private String author;
    private Book book;
    public OtherParse(String isbn) {

        book = new Book(); //initialize book here

        String ruta = "https://www.googleapis.com/books/v1/volumes?q=isbn:";

        this.url = ruta.concat(isbn);

    }

    JSONObject getResult(){
        return this.jsonObject;

    }
    Book getBook(){
        //do all of the network operations in getBook instead of the constructor
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = null;
        System.out.println("Buscando");
        try {
            responseBody = client.execute(get, responseHandler);
        } catch (Exception ex) {
            Log.v("RESPONSEBODY", "Exception: " + ex.getMessage());
        }
        this.jsonObject = null;

        try {
            this.jsonObject = new JSONObject(responseBody);
            System.out.println("JSONRESPONSE =" + this.jsonObject);

        } catch (Exception e) {
            Log.v("TEST", "Exception: " + e.getMessage());
        }
        //Book libro = new Book(); //no need to create a new book here

        JSONArray jArray;
        try {
            jArray = jsonObject.getJSONArray("items");

            System.out.println("JSONARRAY length =" + jArray.length());

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject volumeInfo = jArray.getJSONObject(i).getJSONObject(
                        "volumeInfo");
                book.setTitle(volumeInfo.getString("title"));

                JSONArray authors = volumeInfo.getJSONArray("authors");
                for (int j = 0; j < authors.length(); j++) {
                    this.author = authors.getString(i);
                }
                book.setAuthors(author);

                System.out.println("author =" + author);
            }
            System.out.println("TITULO=" + book.getTitle());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return this.book;
    }

    public class Book{
        String title;
        String authors;

        public void setAuthors(String a){
            authors = a;
        }

        public void setTitle(String t){
            title = t;
        }

        public String getTitle(){
           return title;
        }

        public String getAuthors(){
            return authors;
        }

    }
}