// In your fragment

public interface OnMyFragDismissListener(){
     void onMyFragDismissed(MyObject obj);
}    

// onCreate...

// someCode...

// However you have the user select the option
@Override
public void onDismiss(DialogInterface d){
     if(getActivity() instanceof OnMyFragDismissListener)}
        ((OnMyFragDismissListener)getActivity()).onMyFragDismissed(result); // result being the user choice
     }
}