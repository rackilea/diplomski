Elements e = doc.select("td.yfnc_tabledata1");
Element open = e.get(1);   // index for open is 1
Element volume = e.get(9); // index for volume is 9

System.out.println("Open: " + open.text());
System.out.println("Volume: " + volume.text());