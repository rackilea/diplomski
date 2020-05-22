sb.setFocusTraversable(true);

sb.setOnKeyPressed(e -> {
    if ( e.getCode().equals(KeyCode.RIGHT))
        sb.setValue(sb.getValue()+0.01);
    else if(e.getCode().equals(KeyCode.LEFT))
        sb.setValue(sb.getValue()-0.01);
});