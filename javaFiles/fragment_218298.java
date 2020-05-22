if (isExternalStorageDocument(uri)) {
    final String docId = DocumentsContract.getDocumentId(uri);
    final String[] split = docId.split(":");
    final String type = split[0];

    String extDirectory = Environment.getExternalStorageDirectory().toString();

    if ("primary".equalsIgnoreCase(type)) { //Primary storage
        return extDirectory + "/" + split[1];
    }

    // handle non-primary volumes
    else{
        extDirectory = extDirectory.replace(
                "emulated/0",
                type);
        return extDirectory + "/" + split[1];
    }
}