public class PhotoGalleryFragment extends Fragment {

    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        // some http calls to be triggered

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mProgressDialog = ProgressDialog.show(activity, "", "Loading...", true, false);
    }
}