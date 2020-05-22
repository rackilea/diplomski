WebTarget target = ClientBuilder.newClient().target("some/url");
MultipartFormDataOutput formData = new MultipartFormDataOutput();
Map<String, Object> json = new HashMap<>();
json.put("foo", "bar");
formData.addFormData("json", json, MediaType.APPLICATION_JSON_TYPE);
FileInputStream fis = new FileInputStream(new File("/path/to/image"));
formData.addFormData("image", fis, MediaType.APPLICATION_OCTET_STREAM_TYPE);
Entity<MultipartFormDataOutput> entity = Entity.entity(formData, MediaType.MULTIPART_FORM_DATA);
Response response = target.request().post(entity);