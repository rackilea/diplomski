public class UnitsFragment extends Fragment implements AdapterCallback{ 

    // your other codes

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_units, container, false);
        setHasOptionsMenu(true);

        // .... your other codes

        Log.d(TAG, "onCreateView: " + getContext());

        // modify below line like this
        mAdapter = new UnitsRv(mcontext, unitsLists, this); // here you have to pass an extra parameter that will implement your callback method from adapter.

        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    // ... you other codes

    @Override
    public void prepareSelection(Context context,int position) {
        if(actionMode == null) {
            isInActionMode = true;

            for (String string : list) {
                unitsLists.add(new UnitsList(string));
            }
            mAdapter = new UnitsRv(context, unitsLists,this); // add this as parameter.
            Log.d(TAG, "prepareSelection: " + mAdapter);
            Log.d(TAG, "prepareSelection1: " + dcontext);
            mcontext = (Activity)context;
            actionMode = mcontext.startActionMode(actionModeCallback);

            mAdapter.notifyDataSetChanged();

            if (!selectionList.contains(unitsLists.get(position))) {
                selectionList.add(unitsLists.get(position));
            }
            updateViewCounter();
        }
    }
    // other codes
}