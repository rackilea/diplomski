public class MainActivity extends AppCompatActivity {

EditText userEntry;
Button checkPalindrome;
TextView displayAnswer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    userEntry = findViewById(R.id.edit_demo);
    checkPalindrome = findViewById(R.id.button_demo);
    displayAnswer = findViewById(R.id.guess);

    checkPalindrome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String reverse,stringUserEntry = ""; // Objects of String class
            boolean displayAnswerBool = false;
            stringUserEntry= userEntry.getText().toString();
            reverse=new StringBuilder(stringUserEntry).reverse().toString();

            if (stringUserEntry.equals(reverse)){
                displayAnswerBool = true;
                displayAnswer.setText("this is a palindrome");
            }
            //System.out.println("The string is a palindrome.");
            else{
                displayAnswerBool = false;
                displayAnswer.setText("this is not a palindrome");}
            //System.out.println("The string isn't a palindrome.");

        }
    });

}
}