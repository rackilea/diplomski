for (int i = 0; i < size; i++) {
        tareWeight = vproc.checkTares((String) barcodeList.get(i));

        TareTableEntry entry = new TareTableEntry();
        entry.setBarcodeString(barcodeList.get(i));
        entry.setResult(tareWeight);
        tareWeightList.add(entry);
    }