public class ExampleActivity extends Activity  // Presenter
    implements OtherClass.OnTextChangeListener {

    private EditText editText

    @Override
    void onTextChanged(String text) {
        editText.setText(text); // Present the data
    }

    @Override
    public void onCreate(Bundle b) {
        // Other code...

        // Bind the Presenter to the View
        OtherClass x = new OtherClass();
        x.listener = this; // 'this' being the *interface*, not the Activity
    }

}