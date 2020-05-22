JCoTable tblText = function.getTableParameterList().getTable("LONGTEXTS")
if (tblText == null) {
    throw new Exception("...")
}

def rowNo = 0
tblText.appendRows(meldungsTextLang.size())
for (String text : meldungsTextLang) {
    if (text != null && text.length() > 132) text = text.substring(0, 132)
    tblText.setRow(rowNo++)
    tblText.setValue("OBJTYP","QMSM")
    tblText.setValue("OBJKEY","1")
    tblText.setValue("FORMAT_COL", "*")
    tblText.setValue("TEXT_LINE", text)
}