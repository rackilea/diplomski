public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

public void sum(View v) {
            int sum =0;
    EditText editText = (EditText) findViewById(R.id.editText1);
    sum = getSum(editText.getText().toString());

    TextView tv = (TextView) findViewById(R.id.textView1);
    tv.setText(sum + "");
}
public int getSum(String text) {
    int sum = 0;
    char[] name = new char[text.length()]; // where length is maximum length
                                            // of name.
    name = text.toCharArray();

    for (int i = 0; i < text.length(); i++) {
        sum += value(name[i]);
    }

    // check if sum is greater than 9
    while (sum > 9) {
        sum = findDigitSum(sum);
    }
    return sum;
}

   // find sum of digits if sum is greater than 9

public int findDigitSum(int n) {
    int sum = 0;
    while (n != 0) {
        sum += n % 10;
        n = n / 10;
    }
    return sum;
}
// return value for char
public int value(char a) {
    switch (a) {
        case 'c' :
            return 7;
        case 'a' :
            return 3;
        case 't' :
            return 9;
        case 'e' :
            return 2;
        default :
            return 0;
    }
}