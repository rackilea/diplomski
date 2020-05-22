private int info = 1;
public void nextStep(View view)
{    
    TextView textInfo = (TextView) findViewById(R.id.textInfo);
    int myStrId = textInfo.getContext().getResources().getIdentifier("info"+info, "string", textInfo.getContext().getPackageName());
    textInfo.setText(myStrId);
    info++;
}