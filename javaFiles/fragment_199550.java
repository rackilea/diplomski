File imageFile = new File("C:/ScannerOutput/scannerImage" + System.currentTimeMillis() +".jpeg");
FileOutputStream fos = new FileOutputStream(imageFile);
JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(fos);
JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(image);
jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
jpegEncoder.setJPEGEncodeParam(jpegEncodeParam);
jpegEncodeParam.setQuality(0.75f, false);
jpegEncodeParam.setXDensity(resolutionState); //DPI rate 100, 200 or 300
jpegEncodeParam.setYDensity(resolutionState); //DPI rate 100, 200 or 300
jpegEncoder.encode(image, jpegEncodeParam);
image.flush();
fos.close();