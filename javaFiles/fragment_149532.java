File myPdf=new File(thePath);
FileResourceStream frs = new FileResourceStream(myPdf);

ResourceStreamResource rsr = new ResourceStreamResource(frs);
rsr.setContentDisposition(ContentDisposition.ATTACHMENT);
rsr.setFileName(fileName);

//the same code for resource reference creation and registration
//...