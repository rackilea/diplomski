if(e.getStateChange() == ItemEvent.SELECTED) {
    if(e.getItem() == jcb1) {
        jcb2.setSelected(false);
    } else {
        jcb1.setSelected(false);
    }
}