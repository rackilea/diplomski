lv.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        idProjeto = arrayList.get(position);  // assuming you create a member variable ArrayList<Long> arrayList = new ArrayList<Long>()
        Intent intent = new Intent(ListaProjetosActivity.this, ListaCheckinsActivity.class);    
        intent.putExtra("idProjeto", idProjeto);
        startActivity(intent);