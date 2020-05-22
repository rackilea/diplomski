public class BaseActivity extends AppCompatActivity implements FragmentSideButton.Headline {
    @Override
    public void turnOnMic() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"say something");

        try {
            startActivityForResult(i, 100);
        }catch(ActivityNotFoundException a){
            Toast.makeText(context,"sorry your device does not support speech to text ",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int request_code,int result_code,Intent i){
        super.onActivityResult(request_code,result_code,i);

        switch (request_code)
        {
            case 100: if(result_code == RESULT_OK && i != null){
                ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                //resultText.setText(result.get(0));
                Toast.makeText(context,result.get(0),Toast.LENGTH_SHORT).show();
            }
                break;
        }
    }
}