FileType[] fileTypes;

fileTypes = Image.class.getAnnotationsByType(FileType.class);
System.out.println("fileTypes for Image = " + Arrays.toString(fileTypes));

fileTypes = Worksheet.class.getAnnotationsByType(FileType.class);
System.out.println("fileTypes for Worksheet = " + Arrays.toString(fileTypes));