//java 1.6
private void persistObject(Hashtable ht){
   fout.getChannel().position(initialPosition);
   fout.getChannel().truncate(initialPosition);
   writer.writeObject(ht);
   writer.flush();
}