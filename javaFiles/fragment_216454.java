sshd.setFileSystemFactory(new NativeFileSystemFactory() {
        @Override
        public FileSystemView createFileSystemView(final Session session) {
            return new NativeFileSystemView(session.getUsername(), false) {
                @Override
                public String getVirtualUserDir() {
                    return  "C:\\MyRoot";
                }
            };
        };
    });