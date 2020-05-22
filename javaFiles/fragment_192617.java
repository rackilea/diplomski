@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    int actualPosition = name.indexOf(adapter.getItem(position));

    Intent ij = new Intent(getApplicationContext(), PdfView.class);
    ij.putExtra("furl", "fl/" + file[actualPosition]);
    ij.putExtra("pagenm", pagenum[actualPosition]);
    startActivity(ij);
}