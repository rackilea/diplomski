PDSimpleFileSpecification fileSpec = new PDSimpleFileSpecification(new COSString("/C/dir1/dir2/blah.mp3")); // see "File Specification Strings" in PDF spec
COSStream soundStream = new COSStream();
soundStream.createOutputStream().close();
soundStream.setItem(COSName.F, fileSpec);
soundStream.setInt(COSName.R, 44100); // put actual sample rate here
PDActionSound actionSound = new PDActionSound(); 
actionSound.getCOSObject().setItem(COSName.getPDFName("Sound"), soundStream)); 
link.setAction(actionSound); // reassign the new action to the link annotation