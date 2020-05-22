public class MainActivity extends Activity {

CurrentWeatherFragment currentWeatherFragment;
EditText searchText;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    searchText = new EditText(this);

    currentWeatherFragment = new CurrentWeatherFragment();
    getFragmentManager().beginTransaction().replace(R.id.fragment_container,currentWeatherFragment).commit();

    searchText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if (currentWeatherFragment != null){
                     currentWeatherFragment.searchWeather(charSequence.toString());
                 }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });

}
}