Path path = Paths.get("/home/toto/myfile.zip");
FileOwnerAttributeView foav = Files.getFileAttributeView(path,
      FileOwnerAttributeView.class);

FileSystem fs = FileSystems.getDefault();
UserPrincipalLookupService upls = fs.getUserPrincipalLookupService();

//UserPrincipal new_user = upls.lookupPrincipalByName("brice");     
UserPrincipal new_user = upls.lookupPrincipalByName("1005");
foav.setOwner(new_user);

GroupPrincipal new_group = upls.lookupPrincipalByGroupName("everyone");
Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS).setGroup(new_group);