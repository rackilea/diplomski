final JScrollPane jPane = new JScrollPane(yourPanel);
jPane.getViewport().addChangeListener(new ChangeListener() {

    public void stateChange(ChangeEvent e) {

        //if that is true, it means panel overflowed
        if(jPane.getHorizontalScrollBar().isShowing()) {

        }
    }

})