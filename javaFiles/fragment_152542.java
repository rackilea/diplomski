public class DictionaryFragment ... {
    private Adapter mAdapter;

    public View onCreateView(...) {
        // Init the layout here

        // Put some other ArrayList here if you have one initially, else an empty one to start
        mAdapter = new ArrayAdapter<String>(getContext(), R.layout.kelimelistesi, new ArrayList<String>());

        dicList.setAdapter(mAdapter);
    }

    public void resetDatasource(ArrayList<String> source) {
        mAdapter.clear();
        mAdapter.addAll(source);
        mAdapter.notifyDataSetChanged();
    }

    ...
}