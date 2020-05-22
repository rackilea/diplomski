Account updateAccount = new Account();
        updateAccount.setPassword("test");
        updateAccount.setNamefirst("test");
        updateAccount.setNamelast("test");
        updateAccount.setEmail("test");
        updateAccount.setCity("test");
        updateAccount.setCountry("test");
        updateAccount.setAbout("test");
        BufferedImage img;
        img = ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg"));
        WritableRaster raster = img .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
        byte[] testImage = data.getData();
        updateAccount.setImage(testImage);

        FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
        MockMultipartFile image = new MockMultipartFile("image", fis);


          HashMap<String, String> contentTypeParams = new HashMap<String, String>();
        contentTypeParams.put("boundary", "265001916915724");
        MediaType mediaType = new MediaType("multipart", "form-data", contentTypeParams);

        when(service.updateAccountImage(any(Account.class))).thenReturn(
                updateAccount);
        mockMvc.perform(
                MockMvcRequestBuilders.fileUpload("/accounts/test/updateImage")
                .file(image)        
                    .contentType(mediaType))
                .andDo(print())
                .andExpect(status().isOk());