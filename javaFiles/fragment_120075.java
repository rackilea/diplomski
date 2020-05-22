public class NotesFragment extends Fragment {

    ParseUser user;
    ListView notesList;
    ProgressBar mPB;
    private FloatingActionButton FAB;
    ArrayList<ParseObject> list1 = (ArrayList) ParseUser.getCurrentUser().getList("notes");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        mPB = (ProgressBar) rootView.findViewById(R.id.progress_bar);

        mPB.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mPB.setVisibility(View.GONE);
            }

        }, 3500);

        notesList = (ListView) rootView.findViewById(R.id.lv_contact);
        user = ParseUser.getCurrentUser();

        FAB = (FloatingActionButton) rootView.findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AddNoteActivity.class);
                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                startActivity(intent);
            }
        });


        final ArrayAdapter<ParseObject> arrayAdapter;
        arrayAdapter = new ArrayAdapter<ParseObject>(getContext(), android.R.layout.simple_list_item_1, list1);

        final RelativeLayout emptyView = (RelativeLayout) rootView.findViewById(R.id.empty);

        if (list1 == null) {

            emptyView.setVisibility(View.VISIBLE);
            mPB.setVisibility(View.GONE);


        } else {

            notesList.setAdapter(arrayAdapter);
            emptyView.setVisibility(View.INVISIBLE);

        }

        notesList.setLongClickable(true);
        notesList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new android.app.AlertDialog.Builder(getContext())
                        .setTitle("Delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                list1.remove(position);
                                ParseUser.getCurrentUser().remove("notes");
                                ParseUser.getCurrentUser().put("notes", list1);
                                ParseUser.getCurrentUser().saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {

                                        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();


                                        if (list1.toString().equals("[]")) {

                                            emptyView.setVisibility(View.VISIBLE);
                                            mPB.setVisibility(View.GONE);


                                        } else {

                                            notesList.setAdapter(arrayAdapter);
                                            emptyView.setVisibility(View.INVISIBLE);

                                        }

                                    }
                                });
                            }
                        })


                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .show();
                return true;
            }
        });

        return rootView;
    }
}