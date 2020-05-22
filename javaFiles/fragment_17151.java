try {
    yourRestApi.getSomeDataRestCall();
} catch (RetrofitError e) {
    if (e.getResponse != null) {
        TypedInput body = e.getResponse().getBody();
        byte[] bytes = streamToBytes(body.in());
        String charset = MimeUtil.parseCharset(body.mimeType());
        // This will be your error message
        String errorMsg = new String(bytes, charset);
    }
}