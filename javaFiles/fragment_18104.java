public void onSaveInstanceState(Bundle outState){
    char[][][] a=new char[3][3][3];
    outState.putSerializable("a", a);
}

@Override
protected void onCreate(Bundle savedInstanceState) {
     char[][][] a = (char[][][]) savedInstanceState.getSerializable("a");

     if(a != null)
     {
          //Do something with a
     }

}