// ...
if (actionDict == null) {
    actionDict = new PdfDictionary();
    // add the newly created action dict
    widgetRefDict.put(PdfName.AA, actionDict);
}
// ...