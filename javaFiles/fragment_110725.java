public class BlankFragment extends Fragment {

    private LinearLayout mLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        mLinearLayout= (LinearLayout) view.findViewById(R.id.calendar_container);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final PersianCalendarView persianCalendarView = new PersianCalendarView(getContext());

        // All your remaining PersianCalendarView implementation code here
        mLinearLayout.addView(persianCalendarView);
    }
}