for (int i = 0; i < checkboxes.size() ; i++) {
    if(checkboxes.get(i).isSelected() && colstatuslist.get(i).toUpperCase().equals("FALSE")){
        checkboxes.get(i).click();
    } else if((!checkboxes.get(i).isSelected()) && colstatuslist.get(i).toUpperCase().equals("TRUE")){
        checkboxes.get(i).click();
    }
}