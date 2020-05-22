@Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getAllEditTextsAndCheckBoxes(view);

    }

    public void getAllEditTextsAndCheckBoxes(View view){

        ArrayList<View> returnViews = new ArrayList<View>();

        ArrayList<View> focusableViews = view.getFocusables(View.FOCUS_FORWARD);

        for (int i = 0; i < focusableViews.size(); i++) {

            View actualView = focusableViews.get(i);

            if(actualView instanceof EditText) {
                returnViews.add((EditText) actualView);
            }
            if(actualView instanceof CheckBox) {
                returnViews.add((CheckBox) actualView);
            }

        }

        for(View mView: returnViews){
            if (mView instanceof  EditText){
                Log.d("ash_sow", "EditText Found!!");
            }
            else if(mView instanceof CheckBox){
                Log.d("ash_sow", "CheckBox Found!!");
            }
        }

    }