@Override
    protected List<Uri> doInBackground(List<Uri>... imageUriList) {
        List<Uri> fileList = imageUriList[0];
        List<Uri> filesAdded = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            filesAdded.add(Uri.parse(compressImage(String.valueOf(fileList.get(i)))));
        }
        return filesAdded;
    }