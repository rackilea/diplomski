private String encodeUrl(String link) throws UnsupportedEncodingException {
    Uri uri = (Uri.parse(link));
    String result = null;
    if (Objects.equals(uri.getScheme(), "content")) {
        try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
            }
        }
    }
    if (result == null) {
        result = uri.getPath();
        int cut = Objects.requireNonNull(result).lastIndexOf('/');
        if (cut != -1) {
            result = result.substring(cut + 1);
        }
    }
    return link.replace(result
            ,URLEncoder.encode(result, "UTF-8")
                    .replace("+", "%20"));
}