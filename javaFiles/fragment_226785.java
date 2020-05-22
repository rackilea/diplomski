Path tmpPath = Paths.get("/tmp/"); //valid directory
    String fileName = "foo/bar.xls"; //supplied fileName

    Path filePath = tmpPath.resolve(fileName); //add fileName to path
    Path fileParent = filePath.getParent(); //get parent directory
    System.out.println(fileParent);
    System.out.println(tmpPath.equals(fileParent)); //false because fileParent is '/tmp/foo'