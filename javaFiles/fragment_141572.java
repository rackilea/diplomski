tChart1.getAspect().setView3D(false);
    Line xline = new Line(tChart1.getChart());
    xline.fillSampleValues();

    xline.getPointer().setVisible(true); // 数据点突出显示
    // xline.getPointer().setStyle(PointerStyle.CIRCLE);
    xline.getPointer().setHorizSize(2);
    xline.getPointer().setVertSize(2);
    //xline.getPointer().setColor(Color.black);
    //xline.getPointer().getPen().setColor(Color.black);

    double thr = xline.getYValues().getMinimum() + (xline.getYValues().getMaximum() - xline.getYValues().getMinimum()) / 3;
    for (int i=0; i<xline.getCount(); i++) {
        if (xline.getYValues().getValue(i) > thr) {
            xline.getColors().setColor(i, Color.black);
        }
    }