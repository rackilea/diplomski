public void run()
{
  LayoutInflater inflater = (LayoutInflater)
  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View layout = inflater.inflate(R.layout.endofgame, null, false);
  Button but = (Button) layout.findViewById(R.id.pop_can);
  final PopupWindow pw = new PopupWindow(layout, 300, 300,  true);
  pw.setBackgroundDrawable(new BitmapDrawable());
  OnClickListener cancel_button_click_listener = new OnClickListener() 
  {
    public void onClick(View v) 
    {
      pw.dismiss();
    }
  };
  but.setOnClickListener(cancel_button_click_listener);
  pw.showAtLocation(game_frame_layout, Gravity.CENTER, 0, 0);
}