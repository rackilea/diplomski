public class GeneralDialogFragment extends BaseDialogFragment<GeneralDialogFragment.OnDialogFragmentClickListener> {

        // interface to handle the dialog click back to the Activity
        public interface OnDialogFragmentClickListener {
            public void onOkClicked(GeneralDialogFragment dialog);
            public void onCancelClicked(GeneralDialogFragment dialog);
        }

        // Create an instance of the Dialog with the input
        public static GeneralDialogFragment newInstance(String title, String message) {
            GeneralDialogFragment frag = new GeneralDialogFragment();
            Bundle args = new Bundle();
            args.putString("title", title);
            args.putString("msg", message);
            frag.setArguments(args);
            return frag;
        }
        // Create a Dialog using default AlertDialog builder , if not inflate custom view in onCreateView
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            return new AlertDialog.Builder(getActivity())
                .setTitle(getArguments().getString("title"))
                .setMessage(getArguments().getString("message"))
                .setCancelable(false)
                .setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // Positive button clicked
                            getActivityInstance().onOkClicked(GeneralDialogFragment.this);
                        }
                    }
                )
                .setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // negative button clicked
                            getActivityInstance().onCancelClicked(GeneralDialogFragment.this);
                        }
                    }
                )
                .create();
        }

    }