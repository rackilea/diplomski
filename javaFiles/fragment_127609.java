class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle b){
        ...
        MyAppApplication mApp = ((MyAppApplication)getApplicationContext());
        String globalVarValue = mApp.getGlobalVarValue();
        ...
    }
}