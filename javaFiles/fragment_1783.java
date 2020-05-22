// DO THIS for each entry
ZipEntry e = zipInputStreamObj.getNextEntry();
e.getName // and all data
int size = e.getSize(); // the byte count
while (size > 0) {
   size -= zipInputStreamObj.read(...);
}
zipInputStreamObj.closeEntry();
// DO THIS END

zipInputStreamObj.close();