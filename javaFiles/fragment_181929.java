String url = "http://mmcd.nmrfam.wisc.edu/test/cqsearch.py?cqid=cq_12391";

Document doc = Jsoup.connect(url).get();
Elements select = doc.select("table[width=80%] tr:has(td:matchesOwn(^Name:$)) td:eq(1)");
String name = select.text(); 

System.out.println(name);