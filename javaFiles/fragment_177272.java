strSpinner.addChangeListener(new ChangeListener() {

    @Override
    public void stateChanged(ChangeEvent e) {
        str = strNumberModel.getNumber().intValue();
        remainingPoints = remainingPoints - (str + dex + intel + con + cha);
        if (remainingPoints <= 0) {
            // do something
        }
    }
});