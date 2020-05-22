Document doc = Jsoup
            .connect("http://www.bbc.co.uk/sport/rugby-union/results") 
            .timeout(5000)
            .get();

List<String> list1 = new ArrayList<String>(); //league name
List<String> list2 = new ArrayList<String>(); 
List<String> list3 = new ArrayList<String>();
List<String> list4 = new ArrayList<String>();
List<String> list5 = new ArrayList<String>();

for (Element dataTable : doc.select("div.table-table-stats")) {

    for (Element row : dataTable.select("tr")) {
           Elements td = row.select("td"); 
           list1.add(dataTable.select("p.table-description").text());
           list2.add(td.get(0).text());
           list3.add(td.get(1).text());
           list4.add(td.get(2).text());
           list5.add(td.get(3).text());
    }
}
System.out.println(list1);
System.out.println(list2);
System.out.println(list3);
System.out.println(list4);
System.out.println(list5);