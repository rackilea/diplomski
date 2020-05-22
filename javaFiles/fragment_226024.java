Button a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8;
//private boolean mShouldTakeAction; does not need this anymore
private Button mDisableButton;
.......
.......
final OnClickListener clickListener = new OnClickListener() {
    public void onClick(View v) {

     // We are going to disable button so no need to make it yellow
     //Button button = (Button)v;
     //button.setBackgroundColor(Color.YELLOW);
     if (mDisableButton == null)
     {

           mDisableButton = (Button) v;
           v.setEnabled(false);
     }
     else
     {
          mDisableButton.setEnabled(true);
          mDisableButton = null;
          // do what ever you want here that is compare the terms
     }



        }
 };