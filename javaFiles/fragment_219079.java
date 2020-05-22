public class MainActivity extends Activity implements HomeFragment.OnFragmentInteractionListener {

    .
    .
    .

    @Override
    public void openHome(View view) {
        System.out.println("Success");
    }

    @Override
    public void onFragmentInteractionHome(Uri uri) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

}