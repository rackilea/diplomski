File progFil = new File("...");
  Properties pro = new Properties();
  try{

  FileInputStream in = new FileInputStream(propFile);
  pro.load(in);
  System.out.println("All values of the property file : ");
  Enumeration em = pro.keys();
  while(em.hasMoreElements()){
  String str = (String)em.nextElement();
  System.out.println(str + ": " + pro.get(str));
  }
  }
  catch(IOException e){
  System.out.println(e.getMessage());
  }