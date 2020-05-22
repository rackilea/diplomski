public static class UploadFileResponse {

    boolean ok;
    String error;

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "ok=" + ok +
                ", error='" + error + '\'' +
                '}';
    }
}