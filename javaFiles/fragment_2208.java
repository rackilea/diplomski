@Override
public void onBackPressed() {
if(layout2.getVisibility() == View.VISIBLE){
    setContentView(R.layout.main);
    return;
}else{
    super.onBackPressed(); 
    }

}