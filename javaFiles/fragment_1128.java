public void onClick(View view) {
    CheckedObject[] objectsToCheck = new CheckedObject[]{qOne,qTwo,qThree,qFour};
    int index = flipp.getDisplayedChild();
    if (objectsToCheck[index].isChecked())
    {
         CorrectToast();
    }
    else 
    {
         WrongToast();
    }
}