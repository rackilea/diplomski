MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
 double[] filelimits = {0,1,2};
 String[] filepart = {"no files","one file","{0,number} files"};
 ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
 form.setFormatByArgumentIndex(0, fileform);

 int fileCount = 1273;
 String diskName = "MyDisk";
 Object[] testArgs = {new Long(fileCount), diskName};

 System.out.println(form.format(testArgs));