ArrayList<Row> rows = new ArrayList<>();
for (int i=0; i < ntavolo.length; i++) {
// This is not very safe. If any of the arrays are smaller than the ntavolo array it will crash
    row.add(new Row(bandiera[i], positivo[i], negativo[i], piatti[i], qta[i], ntavolo[i]));     
}
Adapter adapter = new Adapter(this, rows);
lv.setAdapter(adapter);