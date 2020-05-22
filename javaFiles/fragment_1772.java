Storage storage = StorageOptions.builder()
                    .authCredentials(AuthCredentials.createForJson(new FileInputStream(authFile)))
                    .projectId(projectId)
                    .build()
                    .service();

List<Acl> aclList = new ArrayList<>();
aclList.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER)); // shared publicly

BlobInfo blobInfo = BlobInfo.builder(blobId)
                    .acl(aclList)
                    .build();

storage.create(blobInfo, new FileInputStream(template));