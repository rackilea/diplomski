Controller

@RequestMapping(method = RequestMethod.POST, value = "/save")
        public ReturnFormat uploadCSV(@RequestParam("files")  MultipartFile file )
        {
            return uploadingService.uploadCSV( file );
        }
Service class will be like

    public void uploadCSV (MultipartFile multipartFile)
    {
        ReturnFormat rf = new ReturnFormat();
        SuccessErrorList selist = new SuccessErrorList();
        try
        {
            File file = convertMultiPartToFile( multipartFile );

    }

    private File convertMultiPartToFile( MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }