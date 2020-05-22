FilterList andFilter = new FilterList(Operator.MUST_PASS_ALL);
FilterList orFilter = new FilterList(Operator.MUST_PASS_ONE);

Scan scan = new Scan();
scan.setFilter(orFilter);
orFilter.addFilter(rowFilter1);
orFilter.addFilter(andFilter);  // composition

andFilter.addFilter(rowFilter2);
andFilter.addFilter(rowFilter3);