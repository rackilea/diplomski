File desktop = new File(System.getProperty("user.home"), "Desktop");
File adp = new File(desktop, "ADP");
File folder1 = new File(adp, "MagMediaBefore");
File folder2 = new File(adp, "MagMediaAfter");
List<String> beforeMM = Stream.of(folder1.listFiles()) //
        .filter(File::isFile).map(File::getName) //
        .collect(Collectors.toList());
List<String> afterMM = Stream.of(folder2.listFiles()) //
        .filter(File::isFile).map(File::getName) //
        .collect(Collectors.toList());

// Number of Files in each Folder or Directory
System.out.println("Files in FolderA / BeforeMM ----> " //
        + beforeMM.size());
System.out.println("Files in FolderB / AfterMM -----> " //
        + afterMM.size());
System.out.println("------------------------------------");

System.out.println("Before Media Folder Conatins----> " //
        + beforeMM);
System.out.println("After Media Folder  Conatins----> " //
        + afterMM);
System.out.println("------------------------------------");
List<String> result = new ArrayList<>(afterMM);
result.removeAll(beforeMM);
System.out.println("Result: File(s) present in After BUT NOT " //
        + "BeforeMM folder: " + result);