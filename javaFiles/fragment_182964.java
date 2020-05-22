YourActivity extends Activity {
      View a,b,c;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          a = getLayoutInflater().inflate(R.layout.YOUR_LAYOUT_ID, null);
          b = getLayoutInflater().inflate(R.layout.YOUR_LAYOUT_ID, null);
          c = getLayoutInflater().inflate(R.layout.YOUR_LAYOUT_ID, null);
      }
}