String[] allSlotsToDisable={"oneA101","oneB101","oneA102","oneB102"};

for(String toDisable:allSlotsToDisable){
    RadioButton button = buttonMap.get(toDisable);
    if(button!=null) {
        button.setEnabled(false);
    }
}