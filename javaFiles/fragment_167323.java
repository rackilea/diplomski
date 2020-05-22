public static String cleanContentType(String contentType){
        StringBuilder cleanedContentType = new StringBuilder();
        if(contentType.contains(";")){   //It contains paramenter
            cleanedContentType.append(contentType.split(";")[0]).append("; ");
            if(contentType.split(";").length > 1){
                for(int i = 1; i < contentType.split(";").length ; i++){
                    cleanedContentType.append(contentType.split(";")[i].replace(":", "=")).append("; ");
                }
            }
        } else{
            return contentType;
        }

        return cleanedContentType.toString();
    }