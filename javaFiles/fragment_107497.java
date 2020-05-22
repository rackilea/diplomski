ArrayList<ArrayList<ArrayList<String>>> invoiceLogList= new ArrayList<ArrayList<ArrayList<String>>> ();
    ArrayList<ArrayList<String>> invoiceListMain= new ArrayList<ArrayList<String>>();
    ArrayList<String> c = new ArrayList<String>();
    c.add("13");
    c.add("50");
    c.add("43.45");
ArrayList<String> d = new ArrayList<String>();
d.add("728");
invoiceListMain.add(d);
invoiceListMain.add(c);
invoiceLogList.add(invoiceListMain);

  for(int i=0; i < invoiceLogList.size(); i++)
         {
           for(ArrayList<ArrayList<String>> line :invoiceLogList)
           {
              System.out.print(" \n" + line.get(0));
           }

         }