@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if(context instanceof YouInterface){
        listener = (YourInterface)context;
    } 
}