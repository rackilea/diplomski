@Override
public void onBackPressed() 
{
  if (page_number > global.page_number_min) 
  { //does not matter
    page_number--; //does not matter
    global.cancel_toast(0); //stop all toasts
    network_connected = true;
    finish();
  }
  else
  {
    global.cancel_toast(0);
    network_connected = true;
    finish(); //quit activity
    super.onBackPressed(); //quit application
  }

 timer.cancel();
}