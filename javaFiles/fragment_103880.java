@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    MenuItem tikla = classes [position];
    try{
    Class ourClass = Class.forName("com.x.xname." + tikla.className);
    Intent ourIntent = new Intent(Menu.this, ourClass);
    startActivity(ourIntent);
    } catch (ClassNotFoundException e){
        e.printStackTrace();
    }
}