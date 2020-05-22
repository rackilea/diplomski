String indexableDateString = DateTools.dateToString(theDate, DateTools.Resolution.MINUTE);
doc.add(new StringField("importantDate", indexableDateString, Field.Store.YES));
...
TopDocs results = indexSearcher.search(new TermRangeQuery(
    "importantDate",
    new BytesRef(DateTools.dateToString(lowDate, DateTools.Resolution.MINUTE)),
    new BytesRef(DateTools.dateToString(highDate, DateTools.Resolution.MINUTE)),
    true,
    false
));
...
Field dateField = resultDocument.getField("importantDate")
Date retrievedDate = DateTools.stringToDate(dateField.stringValue());