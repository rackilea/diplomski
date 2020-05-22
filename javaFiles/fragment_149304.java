long indexableDateValue = theDate.getTime();
doc.add(new LongField("importantDate", indexableDateValue, Field.Store.YES));
...
TopDocs results = indexSearcher.search(NumericRangeQuery.newLongRange(
    "importantDate",
    lowDate.getTime(),
    highDate.getTime(),
    true,
    false
));
...
Field dateField = resultDocument.getField("importantDate")
Date retrievedDate = new Date(dateField.numericValue());