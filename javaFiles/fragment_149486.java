public class MyActivity extends Activity {
       public void onCreate(Bundle savedInstanceState){
           // ...
           // you can do this in every method not only in onCreate e.g onStart onResume etc.
           // now start LetterDisplay thread
           TextView textView = (TextView) findViewById(R.id.textView); // if you have another id of textView replace R.id.textView to your id

           String text = "Text to show. You can change it";
           int speed = 100; // you can change it to another value

           LetterDisplay letterDisplay = new LetterDisplay(this, textView, text, speed);
           letterDisplay.start(); // now LetterDisplay thread is running
           // EDIT: and start next LetterDisplay thread for second textView
           String secondText = "Second text to show";
           TextView secondTextView = (TextView) findViewById(R.id.second_text_view); // replace R.id.second_text_view with your  id of second textView
           letterDisplay = new LetterDisplay(this, secondTextView, secondText, speed);
           letterDisplay.start();
           // and now two threads is running and updates textViews

       }

}