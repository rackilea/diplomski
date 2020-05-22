@Override
public void onAttach(Context context) {
    super.onAttach(context);
    Log.d("ONATACH:",context.toString());
    try{
        timeListener = (timeInfoDialogListener) context;
    }catch (ClassCastException e){
        throw new ClassCastException(context.toString() + "implementing problem at main activity");
    }
}