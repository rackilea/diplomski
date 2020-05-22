dos.writeInt(yourList.size()); // tell how many items
for (SubImage si: yourList) {
   // write every field, in order (this should be a method called writeSubImage :)
   dos.writeInt(...);
   dos.writeInt(...);
   ...
}

// to read the thing just:
int size = dis.readInt();
for (int i=0; i<size; i++) {
   // read every field, in the same order (this should be a method called readSubImage :)
   dis.readInt(...);
   dis.readInt(...);
   ...
   // create the subimage
   // add it to the list you are recreating
}