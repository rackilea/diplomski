public class MyFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // ...

         Button btnTruncateDBLocationsTable = (Button) rootView.findViewById(R.id.btnTruncateDBLocationsTable);
         btnTruncateDBLocationsTable.setOnClickListener(this);

        // ...
    }

    @Override
    public void onClick(View v) {
        // You can reference dummyTextView here without any problems
    }
}