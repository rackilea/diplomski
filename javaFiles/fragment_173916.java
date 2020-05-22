Query query = parser1.parser("+sport +category:a")
TotalHitCountCollector collector = new TotalHitCountCollector();
search.search(query, collector); 
ctr = collector.getTotalHits();
query = parser1.parser("+sport +category:b")
collector = new TotalHitCountCollector();
search.search(query, collector); 
ctr1 = collector.getTotalHits();