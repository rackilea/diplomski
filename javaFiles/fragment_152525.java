for (int i = 0; i < cbxNum2.getItemCount(); i++) {
    boolean found = false;
    ele = cbxNum2.getItemAt(i).toString();
    for (int j = 0; j < model.getSize(); j++) {
        if (model.getElementAt(j).equals(ele)) {
            found = true;
            break
        }
    }
    if (!found) {
        model.addElement(ele);
    }
}