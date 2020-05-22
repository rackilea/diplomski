public void onItemClick(AdapterView<?> av, View v, int pos,
                            long id) {
    [...]
    ((AppDetail) av.getAdapter().getItem(pos)).setClicked(true);
    [...]
}