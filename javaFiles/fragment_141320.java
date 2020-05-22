public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebDownloadTask task = new WebDownloadTask("username", "password");
        task.setCallback(new AsyncResponse<String>() {
            @Override
            public void onResponse(String response) {
                // Handle response here. E.g. parse into a JSON object
                // Then put objects into some list, then place into an adapter... 
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
            }
        });

        // Use any URL, this one returns a list of 10 users in JSON
        task.execute("http://jsonplaceholder.typicode.com/users");
    }
}