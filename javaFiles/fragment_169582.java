public Document CreateDocument(int loops, int attr, String data[], String dataattr[][][]) {
    Document BetterDoc = DocumentHelper.createDocument();
    Element root = BetterDoc.addElement("root");
    Element[] _data = new Element[loops];
    for (int i = 0; i < loops; i++) {
        _data[i] = root.addElement(data[i]);
        for (int i2 = 0; i < attr; i++) {
            _data[i].addAtribute(dataattr[i][i2][0], dataattr[i][i2][1])
        };
    }    
    return BetterDoc;
}