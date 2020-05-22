BasicFileAttributeView  bfav    = Files.getFileAttributeView(
                                   FileSystems.getDefault().getPath("/dev/null"),
                                   BasicFileAttributeView.class
                                  );
BasicFileAttributes     bfa     = bfav.readAttributes();
System.out.println(new Date(bfa.lastAccessTime().toMillis()));