@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    resetRadioButtons(resultGroup);
    resetRadioButtons(valueGroup);

    checkedResultButtonsId = savedInstanceState.getInt("radGroup1");
    checkedValueButtonsId = savedInstanceState.getInt("radGroup2");

    // if saved values are > 0: set checked state to 'true'
    if(checkedResultButtonsId > 0){
        ((RadioButton)resultGroup.findViewById(checkedResultButtonsId)).setChecked(true);
    }
    if(checkedResultButtonsId > 0){
        ((RadioButton)valueGroup.findViewById(checkedValueButtonsId)).setChecked(true);
    }
}