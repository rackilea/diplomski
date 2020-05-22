FileSystemManager fsManager = VFS.getManager();
 FileObject listendir = fsManager.resolveFile("/home/username/monitored/");
 DefaultFileMonitor fm = new DefaultFileMonitor(new CustomFileListener());
 fm.setRecursive(true);
 fm.addFile(listendir);
 fm.start();