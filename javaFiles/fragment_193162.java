S3Object obj = s3Client.getObject(new GetObjectRequest(bucketName, keyName));
Base64.Decoder decoder = Base64.getDecoder();
InputStream stream = obj.getObjectContent();
InputStreamReader reader = new InputStreamReader(stream);
try{
    return new StreamingOutput(){
        @Override
        public void write(OutputStream output) throws IOException, WebApplicationException{
            //for checking if string has base64 prefix
            char[] pre = new char[4]; //"data" has at most four bytes on a UTF-8 encoding
            boolean containsPre = false;
            int count = 0;
            int nextByte = 0;
            while((nextByte = stream.read()) != -1){
                if(count < pre.length){
                    pre[count] = (char) nextByte;
                    count++;
                }else if(count == pre.length){
                    //determine whether has prefix or not and act accordingly
                    count++;
                    containsPre = (Arrays.toString(pre).toLowerCase().equals("data")) ? true : false;
                    if(!containsPre){
                        //doesn't have Base64 prefix so write all the bytes until this point
                        for(int i = 0; i < pre.length; i++){
                            output.write((int) pre[i]);
                        }
                        output.write(nextByte);
                    }
                }else if(containsPre && count < 25){
                    //the comma character (,) is considered the end of the Base64 prefix
                    //so look for the comma, but be realistic, if we don't find it at about 25 characters
                    //we can assume the String is not encoded correctly
                    containsPre = (Character.toString((char) nextByte).equals(",")) ? false : true;
                    count++;
                }else{
                    output.write(nextByte);
                }
            }
            output.flush();
            output.close();
            stream.close();
        }
    };
}catch(Exception e){
    e.printStackTrace();
    return null;
}