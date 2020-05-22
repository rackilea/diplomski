// grab a copy of the name so we can do the print outside of the sync block
String nameCopy;
synchronized(guard) {
   nameCopy = name;
}
if (nameCopy != null) {
   print(nameCopy);
}