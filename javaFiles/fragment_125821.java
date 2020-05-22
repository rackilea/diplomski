public enum HttpStatusCode {
   OK(200), NO_CONTENT(204), NOT_FOUND(404);
   private int status;
   private HttpStatusCode(int st) { status = st; }
   public int getStatus() { return status; }       
}