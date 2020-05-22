@Override
public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.colourred) {
        //toolBar.setBackgroundColor(Color.RED);
        getWindow().getDecorView().setBackgroundColor(Color.RED);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFCC33"));
        //or like below with color code
        //toolBar.setBackgroundColor(Color.parseColor("#FFCC33"));
        return true;
    }else if(id==R.id.color_green){
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#green_color_code"));
    }else if(id==R.id.other_id){
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#other_color_code"));
    }
}