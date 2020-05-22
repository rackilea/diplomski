@Override
protected void onStart() {
    super.onStart();
    resetRadioButtons(resultGroup);
    resetRadioButtons(valueGroup);

    if(checkedResultButtonsId > 0){
        ((RadioButton)resultGroup.findViewById(checkedResultButtonsId)).setChecked(true);
    }
    if(checkedResultButtonsId > 0){
        ((RadioButton)valueGroup.findViewById(checkedValueButtonsId)).setChecked(true);
    }
}