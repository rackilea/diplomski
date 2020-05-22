Elements info  = dpc.select("tr.odd,tr.even").select("td.team");

    int i = 0;
     String linkText = "";
     String cse_id = null ;
     ArrayList<String> s =new ArrayList<String>();


    for(Element el : info ){
        linkText = el.attr("href");//or el.attr("title")
        s.add(linkText);
     System.out.println(linkText);/or print it



        }
    }