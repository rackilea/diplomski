class GameException extends Exception {
 GameException() {
  super();
 }
 GameException(String msg) {
  super(msg);
 }
 GameException(String msg, Throwable cause) {
  super(msg, cause);
 }
 GameException(Throwable cause) {
  super(cause);
 }
}