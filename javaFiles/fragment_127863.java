int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
View radioButton = radioButtonGroup.findViewById(radioButtonID);
int idx = radioButtonGroup.indexOfChild(radioButton);

switch (idx) {
    case 1:
        doSomething();
        break;
    case 2:
        doSomething();
        break;
}