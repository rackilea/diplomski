@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) 
{

  // TODO Auto-generated method stub
    if(requestCode == REQ_CODE){
               if (resultCode == Activity.RESULT_OK){
                   String date= data.getStringExtra("date");
}
}