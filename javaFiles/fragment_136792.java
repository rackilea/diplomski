public class Categories extends AppCompatActivity {

    public static String Category;
    public static char[] TextList;
    //4 new variables
    private static volatile boolean isJsonLoaded, isButtonClicked;
    private ProgressBar progressBar;
    private final Object locker = 0; //for concurrent modification & synchronization

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        TextView TextViewUsername = findViewById(R.id.TextViewUsername);
        TextViewUsername.setText(UsernameText);

        this.progressBar = findViewById(R.id.progressBar);
        isJsonLoaded = false;
        isButtonClicked = false;

        initButtons();
        getJSON();
    }

    //Slightly beautified your code
    private void initButtons() {
        //Temp array of buttons
        ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(
                (Button) findViewById(R.id.ComputersButton),
                (Button) findViewById(R.id.HobbiesButton),
                (Button) findViewById(R.id.BooksButton),
                (Button) findViewById(R.id.TourismButton),
                (Button) findViewById(R.id.GamesButton),
                (Button) findViewById(R.id.FantasyButton),
                (Button) findViewById(R.id.SportsButton)
        ));

        //Mutual 'onClick' listener for all of them
        View.OnClickListener buttonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the button's name
                String buttonName = getResources().getResourceEntryName(v.getId());
                //Eliminate the "...Button" part
                Category = buttonName.substring(0, buttonName.indexOf("Button"));
                handleButtonClick();
            }
        };

        for (Button button : buttons)
            button.setOnClickListener(buttonClick);
    }

    public void handleButtonClick() {
        synchronized (locker) {
            if (isJsonLoaded) openQuestion();
            else {
                isButtonClicked = true;

                //Show the progress bar
                progressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    void openQuestion() {
        Intent intent = new Intent(this, Question.class);
        startActivity(intent);
    }

    public void getJSON() {
        new Categories.BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "https://allratejohnnycode.000webhostapp.com/List.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextList = result.toCharArray();
            isJsonLoaded = true;
            synchronized (locker) {
                if (isButtonClicked)
                    openQuestion();
            }

            //Hide the progress bar
            progressBar.setVisibility(View.GONE);
        }
    }
}