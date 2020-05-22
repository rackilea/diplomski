@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
{
    View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
    subjectList = new ArrayList<HashMap<String, String>>();
    myListView = (ListView) rootView.findViewById(R.id.textViewMatrix);
     new LoadAllSubject().execute();
    myListView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            String matrix_id = ((TextView) view.findViewById(R.id.textViewMatrix)).getText()
                    .toString();

            // Starting new intent
            Intent in = new Intent(getActivity().getApplicationContext(),
                    SingleSubject.class);

            // sending matrix id to next activity
            in.putExtra(TAG_MATRIX_ID, matrix_id);

            // starting new activity and expecting some response back
            startActivityForResult(in, 100);
        }
    });

    return rootView;
}