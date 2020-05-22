OnClickListener mClickListener=  new OnClickListener()
{

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Log.i(".........","hello"+v.getTag());
        String s =  v.getTag().toString(); // get the tag on button clikc
        speakOut(s); // then call speakOut with the string
    }

};