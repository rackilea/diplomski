for (int i = 0;i < 11;i++) {
        LimitLine ll = new LimitLine(i + 0.5f);
        ll.setLineColor(getColor(R.color.C5));
        ll.enableDashedLine(10f,5f,4f);
        xAxis.addLimitLine(ll);
    }