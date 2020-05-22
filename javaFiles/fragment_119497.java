private Map<String, CheckBox> addCheckboxes(GridPane gpane, String[] strings, int colums){

    Map<String, CheckBox> map = new HashMap<>();

    int row = 0, col = 0;
    for(String s: strings){
        CheckBox checkBox = new CheckBox(s);    
        gpane.add(checkBox, col, row);
        map.put(s, checkBox);

        col = ++col % colums;
        row = col == 0 ? ++row : row;
    }

    return map;
}