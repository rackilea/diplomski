public void onListItemClick(ListView parent, View v, int position, long id){ 

    Bundle bundle = new Bundle(); 
    intent = new Intent(getapplicationcontext(),MapActivity.class); 
    bundle.putString("string", strings[position]); intent.putExtras(bundle);
    startActivity(intent);
}