for (int i = 0; i < size; i++) {
        tareWeight = vproc.checkTares((String) barcodeList.get(i));
        tw = Double.toString(tareWeight);
        String temp = barcodeList.get(i).toString();

        GetTareByBarcodeForm f = new GetTareByBarcodeForm();
        f.setBarcodeString(temp);
        f.setResult(tw);
        tareWeightList.add(f);
    }