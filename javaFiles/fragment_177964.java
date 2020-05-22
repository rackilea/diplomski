public class BlankFragment extends Fragment {


    private ImageView imv1;
    private ImageView imv2;
    private ImageView imv3;
    private ImageView imv4;
    private ImageView imv5;
    private ImageView imv6;
    private ImageView imv7;
    private ImageView imv8;
    private ImageView imv9;
    ProgressDialog progressDialog = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imv1 = (ImageView) getActivity().findViewById(R.id.imageView);
        imv2 = (ImageView) getActivity().findViewById(R.id.imageView2);
        imv3 = (ImageView) getActivity().findViewById(R.id.imageView3);
        imv4 = (ImageView) getActivity().findViewById(R.id.imageView4);
        imv5 = (ImageView) getActivity().findViewById(R.id.imageView5);
        imv6 = (ImageView) getActivity().findViewById(R.id.imageView6);
        imv7 = (ImageView) getActivity().findViewById(R.id.imageView7);
        imv8 = (ImageView) getActivity().findViewById(R.id.imageView8);
        imv9 = (ImageView) getActivity().findViewById(R.id.imageView9);
    }

    private void setImage() {
        // show progress dialog
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // set your images here.
            }
        });
        // dismiss progressDialog here
    }
}