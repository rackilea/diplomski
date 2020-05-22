private void SaveSwingINI(ArrayList<SingleAccValue> al_SavedAccValues) {
        if(al_SavedAccValues.size()>=150) {
            SingleSwing swing = new SingleSwing();
            ArrayList<SingleAccValue> al_SwingValues = new ArrayList<>(al_SavedAccValues);
            swing.setAl_MeasureData(al_SwingValues);
            alSwingsCurSession.add(swing);
        }
    }