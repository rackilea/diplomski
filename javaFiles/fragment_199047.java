String m = "Ashton Athletic,3-2,08/01/2011,Hounslow Harriers,10905,17.50,2013" ; 
   String[] d = m.split(",");
   String[] d1 = d[1].split("-") ;
   int[] result = new int[2];
   result[0]  = Integer.parseInt(d1[0]) ;
   result[1]  = Integer.parseInt(d1[1]) ;
   System.out.println(result[0]);
   System.out.println(result[1]);