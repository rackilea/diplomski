Gson gson = new Gson();
System.out.println("this record will be created in the source document");
String fichier ="C:\\Users\\programming\\Personne_source.txt";
byte[] encoded =Files.readAllBytes(Paths.get(fichier));
System.out.println("JSON: " + new String(encoded, "UTF-8"));
Student s1 = new Student();
try
{
    s1 = gson.fromJson(new String(encoded, "UTF-8"), Student.class);
    System.out.println(s1 +" s1 have been serialized");
}
catch (IllegalStateException | JsonSyntaxException e1)
{
    System.out.println("error in getting the object");
    e1.printStackTrace();
}
System.out.println(s1.toString());