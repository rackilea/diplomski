public class SimpleArgFragment extends Fragment {
    public static SimpleArgFragment newInstance(boolean val) {
        Bundle args = new Bundle();
        args.putBoolean("param", val);
        SimpleArgFragment f = new SimpleArgFragment();
        f.setArguments(args);
        return f;
    }

    @androidx.annotation.RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public SimpleArgFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null)
            throw new IllegalArgumentException("Missing arguments - use newInstance() to create.");
    }
}