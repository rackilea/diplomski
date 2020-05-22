while (zipEntries.hasMoreElements()) {
  //fname should have the full path
  if (ze.getName().startsWith(fname) && !ze.isDirectory())
    //it is a file within the dir, and it isn't a dir itself
    ...extract files...
  }
}