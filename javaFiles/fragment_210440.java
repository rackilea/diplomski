pD = new PairedData[labels.length];

for (i = 0; i < labels.length; i++)
    pD[i] = new PairedData(labels[i], vals[i]);  // assuming you
                                                 // added this
                                                 // constructor