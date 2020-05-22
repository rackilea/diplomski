/**
 * Method to start new game
 */
private View.OnClickListener mNewGameBtnListener = new View.OnClickListener(){
    @Override
        public void onClick(View v){
            ((MainActivity)getActivity()).doNewGame();
            dismiss();
    }
};