String imageName = "C:\\Documents and Settings\\home\\Desktop\\P092870.jpg";
File input = new File(imageName);
System.out.println("System Type description of " + input.getName() + " is " + 
          FileSystemView.getFileSystemView().getSystemTypeDescription(input));
System.out.println("Mime Type of " + input.getName() + " is " +
          new MimetypesFileTypeMap().getContentType(input));