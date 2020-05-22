list1.setOnItemClickListener(
            new OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> arg0, View view,
                        int position, long id) {

    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    String positie = classes[position];
    try{
    Class ourClass = Class.forName("com.jacob.eindproject.MAIN" + positie);
    Intent ourIntent = new Intent(Menu.this, ourClass);
    startActivity(ourIntent);
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
}
                }
         );