Handler handler;
// On create handler need to be set
handler=new Handler();
runnable.run();

@Override
protected void onStop() {
    super.onStop();
    handler.removeCallbacks(runnable);
}

private int getColorCode(){
    int[] color = {
            R.color._1, R.color._2, R.color._3,R.color._4
    };
    int min = 0,max = color.length;
    Random r = new Random();
    int i= r.nextInt(max - min);
    return color[i];
}

private Runnable runnable = new Runnable()
{
    public void run()
    {
        try {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineLinearLayout);
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),getColorCode()));

            handler.postDelayed(runnable, 300);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
};