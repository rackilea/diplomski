@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mFragmentCallback = (IFragmentCallback) context;

        }catch (Exception ex){
            A35Log.e(TAG, "Parent Context does not implement fragmentCallback");

        }
    }

public void setQuote(Quote showQuote){
     mSelectedQuote = showQuote;
}

btnDelete_onClick(){
    if(mFragmentCallback != null){
         mFragmentCallback.onDeleteQuote(mSelectedQuote);
    }
}