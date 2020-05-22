HorizontalFieldManager hManagerBinHeight = new HorizontalFieldManager(FIELD_BOTTOM);

    LabelField lblRadiusOfBin = new LabelField("Radius of Bin: ", LabelField.FIELD_LEFT);

    EditField txtRadiusFeet = new EditField("Feet: ", "", 3, BasicEditField.FILTER_NUMERIC) {
        // Limit the width of the edit field to be the half of the available width
        protected void layout(int width, int height) {
            super.layout(width/2, height);
        }
    };
    txtRadiusFeet.setBorder(BorderFactory.createRoundedBorder(new XYEdges()));

    EditField txtRadiusInches = new EditField("Inches: ", "", 2, BasicEditField.FILTER_NUMERIC);
    txtRadiusInches.setBorder(BorderFactory.createRoundedBorder(new XYEdges()));

    HorizontalFieldManager hfm = new HorizontalFieldManager(USE_ALL_WIDTH);
    hfm.add(txtRadiusFeet);
    hfm.add(txtRadiusInches);

    hManagerBinHeight.add(lblRadiusOfBin);
    hManagerBinHeight.add(hfm);

    add(hManagerBinHeight);