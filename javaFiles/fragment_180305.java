public boolean onCreateOptionsMenu(android.view.Menu menu)
{
        super.onCreateOptionsMenu(menu);
    MenuInflater awesome=getMenuInflater();
    awesome.inflate(R.menu.main_menu, menu);
    return true;
} // <----------------------- Missing closing brace
     public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
        case R.id.menuSweet:
            startActivity(new Intent("com.example.startandroidkj.SWEET"));
            return true;
        case R.id.menuToast:
            Toast andEggs =Toast.makeText(menu.this,"this is a toast", Toast.LENGTH_LONG);
            andEggs.show();
            return true;

        }

        return false;
    }