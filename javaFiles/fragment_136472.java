......
......
public void onClick(
        DialogInterface dialogInterface, int i) {
    try {
        Runtime.getRuntime()
        .exec("/system/xbin/rm -rf "
                + selectedfolder
                .getAbsolutePath()
                .toString());
        refreshListView();

    } catch (IOException e) {
        e.printStackTrace();
        return;
    }
}
......
......
protected void refreshListView() {
    fsitem = NameManager.getfsiList();
    NameManager.WriteName(fsitem);
    MatrixCursor cursor = NameManager.getnameList();
    ListView list = (ListView) getListView();
    String[] from = { "name", "info", "status", "path", "folder", BaseColumns._ID };
    int[] to = { R.id.name, R.id.info, R.id.status, R.id.path };
    final SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.row, cursor, from, to);
    list.setAdapter(adapter);

}