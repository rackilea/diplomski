final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
        formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("action", "updateprofile")
                .addFormDataPart("userfile", URLEncoder.encode(file.getName(), "utf-8"), RequestBody.create(MEDIA_TYPE_PNG, file))
                .addFormDataPart("userid", user.getId())
                .addFormDataPart("name", name.getText().toString())
                .build();