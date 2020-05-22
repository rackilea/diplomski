public class Fragment_Item extends Fragment {

    private OnFragmentInteractionListener mListener;

    .
    .


    public interface OnFragmentInteractionListener {
        public void onFragmentInteractionHome(Uri uri);
        public void openHome(View view);
    }

}