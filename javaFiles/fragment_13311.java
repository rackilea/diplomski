PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName));

try {

  for (int i = 0; i < data.size(); i++) 
      writer.write(data);

} catch (Exception e) {
  System.err.println("Some exception");
} finally {
   writer.close();
}