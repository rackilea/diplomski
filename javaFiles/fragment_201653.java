try {    

  MongoCursor<Document> cursor = collection.find().iterator();
  String path = "./outputData.txt";

  PrintWriter out = new PrintWriter(
    new BufferedWriter(new FileWriter(path, true))
  );

  while(cursor.hasNext()){
    out.println(cursor.next().toJson());
  }

  out.flush();            // flush to ensure writes
  out.close();            // close the handle when done

} catch (IOException e) {
  System.out.println("Error writing to file.");
}