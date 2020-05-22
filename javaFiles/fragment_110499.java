ResultQuery<Record1<Date>> query = // ...

// Use two method calls (this may result in a NullPointerException!
// as fetchOne() may return null):
Date date1 = query.fetchOne().value1();

// Use fetchValue():
Date date2 = getDSLContext().fetchValue(query);