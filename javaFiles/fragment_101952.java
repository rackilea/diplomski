public class TokenWrapper {
  private final AtomicReference<Token> tokenRef = new AtomicReference<>(null);
  private final Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);

  public TokenWrapper() {
    Token newToken = // refresh token
    tokenRef.set(newToken);
  }

  public Token getToken() {
    Token token = null;
    while((token = tokenRef.get()) == null) {
      semaphore.acquire();
    }
    return token;
  }

  public Token refreshToken(Token oldToken) {
    if(tokenRef.compareAndSet(oldToken, null)) {
      semaphore.drainPermits();          
      Token newToken = // refresh token
      tokenRef.set(newToken);
      semaphore.release(Integer.MAX_VALUE);
      return newToken;
    } else return getToken();
  }
}

public class RESTService {
  private static final TokenWrapper tokenWrapper = new TokenWrapper();

  public void run() {
    Token token = tokenWrapper.getToken();
    Response response = // call service with token
    if(response.getStatus == 401) {
      tokenWrapper.refreshToken(token);
    }
  }
}