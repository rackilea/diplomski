@Bean
public CommonsMultipartResolver multipartResolver(){
    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
    commonsMultipartResolver.setMaxInMemorySize(MEMORY_SIZE);
    commonsMultipartResolver.setMaxUploadSize(UPLOAD_SIZE);
    return commonsMultipartResolver;
}