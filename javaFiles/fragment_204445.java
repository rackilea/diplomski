import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText et;
    String specialCharSet = "!@%$^&#@$*";

    InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            String tmp;
            try {
                tmp = (et.getText().toString()).substring(et.getText().toString().length() - 2, et.getText().toString().length());

                if (Character.isDigit(tmp.charAt(0)) && Character.isDigit(tmp.charAt(1)) && Character.isDigit(source.toString().charAt(0))) {
                    return "";
                }

                if (specialCharSet.contains("" + tmp.charAt(1)) && specialCharSet.contains("" + source)) {
                    return "";
                }
            } catch (Exception e) {
                if (et.getText().toString().length() >= 1 && specialCharSet.contains("" + et.getText().toString().charAt(0)) && specialCharSet.contains(source)) {
                    return "";
                }
            }

            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        et.setFilters(new InputFilter[] { filter });

    }

}