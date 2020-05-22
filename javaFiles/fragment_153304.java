List<MultipartBody.Part> projectParts = new ArrayList<>();

    for (int i = 0; i < mFilesTobeincluded.size(); i++) {
        File file = new File(mFilesTobeIncluded.get(i));
        String boundary = String.valueOf(System.currentTimeMillis());

        Log.d(TAG, "requestUpload: image " + i + "  " + mFilesTobeincluded.get(i));
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse("multipart/form-data; boundary=" + boundary),
                        file
                );
        projectParts.add(MultipartBody.Part.createFormData("name_of_key", file.getName(), requestFile));
    }