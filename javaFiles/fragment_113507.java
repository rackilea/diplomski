public class Frag1 extends Fragment {
    private UpdateSerachViewList mCallback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (UpdateSerachViewList) context; 
// If exception is throws it measn you want to use frafgment with activity which does not implement communication contract. Design error
    }

    @Override
    public void onStart() {
        super.onStart();
        mCallback.update(...);
    }
}