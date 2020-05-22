private void initialize() {
    // TODO Auto-generated method stub
    ptadd = (EditText) findViewById(R.id.etadd);
    lvTodo = (ListView) findViewById(R.id.lvTodo);
    badd = (Button) findViewById(R.id.badd);
    badd.setOnClickListener(this);

    //Missing this
    setListViewListener();
}