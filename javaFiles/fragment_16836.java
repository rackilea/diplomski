SelectBox.SelectBoxStyle boxStyle = new SelectBox.SelectBoxStyle();
    //creating boxStyle...

    String[] values = new String[]{"value1", "value2", "value3", "value4"};
    SelectBox<String> selectBox = new SelectBox<String>(boxStyle);
    selectBox.setItems(values);