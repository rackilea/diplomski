Button button = (Button) findViewById(R.id.button1);
 button.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
   String url1 = "https://www.example.com";
   new DownloadFile().execute(false, url1); // first example
   new DownloadFile().execute(url1, pathToDownloadTo); //second example
}
});


Button button2 = (Button) findViewById(R.id.button2);
button2.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
   String url2 = "https://www.example2url.com";
   new DownloadFile().execute(false, url2); // first example
   new DownloadFile().execute(url2, pathToDownloadTo); //second example
}
});