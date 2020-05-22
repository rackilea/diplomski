//region -- Code stub to create the buffered image --
        BufferedImage result = new BufferedImage(zvDestImg.width, zvDestImg.height, BufferedImage.TYPE_BYTE_GRAY);
        DataBuffer buffer = new DataBufferByte(zvDestImg.nativeData, zvDestImg.nativeData.length);
        SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, zvDestImg.width, zvDestImg.height, 1, zvDestImg.stride, new int[]{0});
        Raster raster2 = Raster.createRaster(sampleModel, buffer, null);
        result.setData(raster2);
        //endregion