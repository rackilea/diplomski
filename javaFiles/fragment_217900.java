@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if(savedInstanceState != null) {
        int pos = (Integer) savedInstanceState.getSerializable("POS");
        if (!movieDataList.isEmpty()) {
            movieDataList = Arrays.asList((movieData[]) savedInstanceState.getSerializable("OLDMOVIEDATA"));
        }
       // movieGridView.setSelection(pos); // You can't do this here!
    }

}