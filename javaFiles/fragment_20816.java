BufferedImage jpg = ImageIO.read(new File("myjpg.jpg"));

    //Convert the image to a byte array 
    DataBufferUShort buff = (DataBufferUShort) jpg.getData().getDataBuffer();
    short[] data = buff.getData();
    ByteBuffer byteBuf = ByteBuffer.allocate(2*data.length);
    int i = 0;
    while (data.length > i) {
        byteBuf.putShort(data[i]);
        i++;
    }

    //Copy a header 
    DicomInputStream dis = new DicomInputStream(new File("fileToCopyheaderFrom.dcm"));
    Attributes meta = dis.readFileMetaInformation();
    Attributes attribs = dis.readDataset(-1, Tag.PixelData);
    dis.close();

    //Change the rows and columns
    attribs.setInt(Tag.Rows, VR.US, jpg.getHeight());
    attribs.setInt(Tag.Columns, VR.US, jpg.getWidth());
    System.out.println(byteBuf.array().length);
    //Attributes attribs = new Attributes();

    //Write the file
    attribs.setBytes(Tag.PixelData, VR.OW, byteBuf.array());
    DicomOutputStream dcmo = new DicomOutputStream(new File("myDicom.dcm"));
    dcmo.writeFileMetaInformation(meta);
    attribs.writeTo(dcmo);
    dcmo.close();