for (int i = 0; i <vDatos.size(); i++) {    
  HashMap tabla = ((HashMap) vDatos.get(i));
  descri = "Hello";
  tabla.put("DESCRIPTION",descri); 
  HashMap foo = ((HashMap) vDatos.get(i));  
  System.out.println(foo.get("DESCRIPTION"));
}