public static void main(String[]someVariableName) throws IOException{ 

 HashMap<String, Integer> hm=new HashMap<String, Integer>();
 hm.put("hydrogen", 1);
 hm.put("helium", 2);
 ...

 System.out.println("Please enter an element");
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 String name=br.readLine();
 System.out.println(hm.get(name));