HorizontalFieldManager hManagerBinHeight = new HorizontalFieldManager(FIELD_BOTTOM);

    LabelField lblRadiusOfBin = new LabelField("Radius of Bin: ", LabelField.FIELD_LEFT);

    final EditField txtRadiusFeet = new EditField("Feet: ", "", 3, BasicEditField.FILTER_NUMERIC);
    txtRadiusFeet.setBorder(BorderFactory.createRoundedBorder(new XYEdges()));
    final EditField txtRadiusInches = new EditField("Inches: ", "", 2, BasicEditField.FILTER_NUMERIC);
    txtRadiusInches.setBorder(BorderFactory.createRoundedBorder(new XYEdges()));

    HorizontalFieldManager hfm = new HorizontalFieldManager(USE_ALL_WIDTH) {
        protected void sublayout(int maxWidth, int maxHeight) {
            layoutChild(txtRadiusFeet, maxWidth/2, maxHeight);
            layoutChild(txtRadiusInches, maxWidth/2, maxHeight);
            setPositionChild(txtRadiusFeet, 0, 0);
            setPositionChild(txtRadiusInches, txtRadiusFeet.getWidth(), 0);

            setExtent(maxWidth, txtRadiusFeet.getHeight());
        };
    };
    hfm.add(txtRadiusFeet);
    hfm.add(txtRadiusInches);

    hManagerBinHeight.add(lblRadiusOfBin);
    hManagerBinHeight.add(hfm);

    add(hManagerBinHeight);