@RequestMapping(value="/api/attachments/temporary")
public ServiceResponse uploadFile(MultipartHttpServletRequest request){

if (request.getFileNames().hasNext()) {
            //1. get the files from the request object
            Iterator<String> itr = request.getFileNames();
            MultipartFile multipartFileImage = request.getFile(itr.next());
            StringBuilder sb=new StringBuilder(multipartFileImage.getOriginalFilename());

            String filename=sb.substring(sb.lastIndexOf("."), sb.length()); // getting file extension
            filename="("+email+")"+filename; // concatenation unique value i.e email to its file name with extension
            user.setProfileImage(filename);

        try {
            File saveImage = new File(imagePath+filename);  //Local path for image file

            PropertiesCredentials cred = new PropertiesCredentials(getClass().getClassLoader().getResourceAsStream(awsCredentialsProperties));
            logger.debug("Aws access key id :"+cred.getAWSAccessKeyId());
            logger.debug("Aws Secret key :"+cred.getAWSSecretKey());
            AWSCredentials credentials = new BasicAWSCredentials(cred.getAWSAccessKeyId(),
                      cred.getAWSSecretKey()
                    );

            AmazonS3 s3client = AmazonS3ClientBuilder
                      .standard()
                      .withCredentials(new AWSStaticCredentialsProvider(credentials))
                      .withRegion(#) // Your region
                      .build();

            PutObjectResult putResult = s3client.putObject(
                      "<bucket name>", 
                      filename, 
                      saveImage
                    );
            multipartFileImage.transferTo(saveImage);
            logger.debug("putResult :"+putResult.getVersionId());
        }catch(Exception e) {
            return ServiceResponse.createFailureResponse("Unable to upload image due to internet connection failure. Try again later.");
        }

}