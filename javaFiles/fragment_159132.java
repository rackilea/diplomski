TextView textView;
Handler handler = new Handler();  
int count = 0;

protected void onCreate(Bundle savedInstanceState)
{
    handler.post(updateTextRunnable);
}

Runnable updateTextRunnable = new Runnable()
{  
    public void run() 
    {  
       count++;
       textView.setText("Updating variable: " + count);
       handler.postDelayed(this, TIME_DELAY);  
    }  
};