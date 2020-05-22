Option<Date> d = parseWithPatterns(someString,
                                   stream("dd/MM/yyyy", "dd-MM-yyyy"));
if (d.isNone()) {
  // Handle the case where neither pattern matches.
} 
else {
  // Do something with d.some()
}