public class RegisterActivity extends AppCompatActivity implements 
            CountryAdapter.onListClickedRowListner {
    .
    .
    .

       @Override
        public void onListSelected (int listposition){
         Log.d("Tag",""+listposition);
       }
}