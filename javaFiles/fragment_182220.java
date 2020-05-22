public class MyFragment extends Fragment implements TextWatcher {

    //some other code...

    @Override
    public void afterTextChanged(Editable s) {
         //TODO: Calculations...  
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //Nothing to do here...
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //Nothing to do here...
    }
}