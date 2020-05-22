jf.setFileView(new FileView(){
            public Icon getIcon(File f)
            {
                return FileSystemView.getFileSystemView().getSystemIcon(f);
            }
        });