listView_prev.setOnItemClickListener(new AdapterView.OnItemClickListener() {


    @Override
    public void onItemClick(AdapterView<?> arg0, final View arg1, int arg2, long arg3) {
        //listview click event handling
       TextView id = (TextView) arg1.findViewById(R.id.textView17);
        final int id_To_Search = Integer.valueOf(id.getText().toString());
        Cursor item=mydb.singlecons(id_To_Search);
        Cursor att=mydb.attrs(id_To_Search);
        Cursor picloc=mydb.singleconspic(id_To_Search);
        att.moveToFirst();
        List<String> list = new ArrayList<>();
      //  Log.d("temp",att.getColumnName(1));

        while (!att.isAfterLast())
        {
            int l=att.getColumnCount();
            Log.d("length", String.valueOf(l));
            for(int i=2;i<l;i++){
            Log.d("for","for");
                if(att.getString(i)!=null){
                    String b= att.getColumnName(i)+" "+att.getString(i);
                    list.add(b);
                    Log.d("att",b);
                }
            }
            Log.d("while","while");
            att.moveToNext();
        }
        att.close();
        Log.d("list", String.valueOf(list));
        picloc.moveToFirst();

        FilePathStrings = new String[picloc.getCount()];
        int i=0;
        while (!picloc.isAfterLast()){
            Log.d("picloc",picloc.getString(2));
            FilePathStrings[i]=picloc.getString(2);
            i++;
            picloc.moveToNext();
        }

        item.moveToFirst();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Consultation.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_label_editor, null);
        dialogBuilder.setView(dialogView);

        TextView con=(TextView)dialogView.findViewById(R.id.textView29);
        con.setText("Consultation on "+item.getString(4));
        TextView des=(TextView)dialogView.findViewById(R.id.textView28);
        des.setText(item.getString(2));
        TextView pre=(TextView)dialogView.findViewById(R.id.textView31);
        pre.setText(item.getString(3));
        TextView fee=(TextView)dialogView.findViewById(R.id.textView32);
        fee.setText(item.getString(5));
        adapter1 = new GridViewAdapter(FilePathStrings,getApplicationContext());
        grid = (GridView) dialogView.findViewById(R.id.gridview);
        grid.setAdapter(adapter1);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();