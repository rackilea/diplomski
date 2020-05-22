//java 1.7
private void persistObject(Hashtable ht){
   fout.getChannel().position(initialPosition);
   fout.reset();
   writer.writeObject(ht);
   writer.flush();
}