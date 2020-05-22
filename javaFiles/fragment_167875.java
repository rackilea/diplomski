public class OkCancelDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";

    Context context = null;

    private String title;
    private String message;
    private boolean submitData = false;

    private OkCancelDialogListener mListener;

    public OkCancelDialogFragment() {
    }

    public static OkCancelDialogFragment newInstance(String title, String message) {
        OkCancelDialogFragment fragment = new OkCancelDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            message = getArguments().getString(ARG_MESSAGE);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle saveIntsanceState){

        context = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View rootView = inflater.inflate(R.layout.fragment_ok_cancel_dialog, null, false);
        final TextView titleView = (TextView)rootView.findViewById(R.id.tvTitle);
        final TextView messView = (TextView)rootView.findViewById(R.id.tvMessage);

        titleView.setText(title);
        messView.setText(message);

        builder.setView(rootView)
//                .setTitle(title)
                .setPositiveButton(R.string.ok_button_dialog_title, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        submitData = true;
                        if(mListener == null) mListener = (OkCancelDialogListener) context;
                        mListener.onFinishOkCancelDialog(submitData);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        submitData = false;
                        if(mListener == null) mListener = (OkCancelDialogListener) context;
                        mListener.onFinishOkCancelDialog(submitData);
                    }
                });
        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if(mListener == null) mListener = (OkCancelDialogListener) context;
        }
        catch (Exception ex){
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OkCancelDialogListener {
        void onFinishOkCancelDialog(boolean submit);
    }

}