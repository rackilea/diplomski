public class RegWizardFragmentInfo extends Fragment {

    private Button button;

    private OnClickCallback callback;

    public interface OnClickCallback {
        void onClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (OnClickCallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick();
            }
        });
    }
}