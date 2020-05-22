for (int i = 0; i < outputModel.getSize(); i++) {
     if(inputList.isSelectedIndex(i)){
         inputModel.addElement(outputModel.getElementAt(i));
         outputModel.remove(i);
     }
}