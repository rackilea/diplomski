if ("SOS\r\n".equals(data))
{
  final long startTime = System.currentTimeMillis();
  final Handler handler = new Handler();
  final int delay = Integer.parseInt(cancelTime.getText()) * 1000;
  final long endTime = startTime + delay;
  wasCanceled = false;
  alertButton.setOnClickListener(new View.OnClickListener()
  {
    @Override
    public void onClick(View view)
    {
      wasCanceled = true;
    }
  });
  final Runnable r = new Runnable()
  {
    @Override
    public void run()
    {
      final double remainingTime = (endTime - System.currentTimeMillis()) / 1000d;
      alertButton.setText("CANCEL THE SOS: " + elapsedTime);
      alertButton.setBackgroundColor(Color.parseColor("#FF0000"));
      if(wasCanceled)
      {
        alertButton.setText("CANCELED!!");
        alertButton.setTextColor(Color.parseColor("#008000"));
        return;
      }
      else if(remainingTime < 0)
      { 
        // SEND SMS
        return;
      }
      handler.postDelayed(r, 1000);
    }
  };        
  handler.postDelayed(r, 1000);
}