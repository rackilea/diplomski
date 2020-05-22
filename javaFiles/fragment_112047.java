class XmlDatabase {

Document doc = readXml();

synchronized Date readDate()  {
    Date _date = getDateFromDoc(doc);
    return _date;
}

synchronized void writeDate(Date _date) {
    addDateToDoc(_date);
    writeDocToFile(doc);
}