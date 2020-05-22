@PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)  
public void fileUpload (@RequestParam MultipartFile file){

        ByteArrayInputStream bis=new  ByteArrayInputStream(file.getBytes());        

        try(BufferedReader br=new BufferedReader(new InputStreamReader(bis))){          
        long count = br.lines().count();
        System.out.println(">>> total lines : "+count);
  }

}