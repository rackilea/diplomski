//In Fragment
    @Override
    public void onDestroyView() {
        super.onDestroyView();
            Activity act = getActivity()
            if(act instanceof SetPreviousTextInterface){
                //setTitlePreviousText will be called giving you the chance to just change it back...
            ((SetPreviousTextInterface)act).setTitlePreviousText();
            }
    }