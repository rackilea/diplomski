public class SavedScanFragment extends Fragment{

//....to restore the saved state
@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    //Restore the fragment state here
    db = new Database(getContext());
    getScans();

}
//add this to save instant state
  @Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    //save your important variable here to outstate
}
}