ZipParameters zp = new ZipParameters();
zp.setFileNameInZip("sample.zip");
System.out.println(zp.getCompressionMethod());
System.out.println(Zip4jConstants.COMP_DEFLATE);

OutPut:
8
8