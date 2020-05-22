String txt = "CSVRecord [comment=null, mapping={Id=0, FirstName=1, LastName=2}, recordNumber=1, values=[1, John, Wayne]]";

String[] sub = txt.substring(txt.indexOf("values=[")).split("[\\[\\]]");


System.out.println(sub[1]);