public class MyFragment extends Fragment {

    MyCallback callback;

    @Override
    public void onAttach(Activity activity) {
        try {
            callback = (MyCallback) activity;
        } catch (ClassCastException ex){
            throw new ClassCastException("Hosting activity must implement " 
               + MyCallback.class.getSimpleName());
        }
        super.onAttach(activity);
    }
}