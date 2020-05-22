public class EntitySynchronizer {
    private Map<Object, Token> tokens = new HashMap<Object, Token>();
    private ThreadLocal<Token> currentToken = new ThreadLocal<Token>();
    private Object mutex = new Object();

    ...

    public void lock(Object key) throws InterruptedException {
        Token token = checkOut(key);
        boolean locked = false;
        try {
            locked = token.lock.tryLock(maximumLockDurationSeconds, TimeUnit.SECONDS));
            if (locked) currentToken.set(token);
        } finally {
            if (!locked) checkIn(token);
        }
    }

    public void unlock() {
        Token token = currentToken.get();
        if (token != null) {
            token.lock.unlock();
            checkIn(token);
            currentToken.remove();
        }
    }

    private Token checkOut(Object key) {
        synchronized (mutex) {
            Token token = tokens.get(key);
            if (token != null) {
                token.checkedOutCount++;
            } else {
                token = new Token(key); 
                tokens.put(key, token);
            }
            return token;
        }
    }

    private void checkIn(Token token) {
        synchronized (mutex) {
            token.checkedOutCount--;
            if (token.checkedOutCount == 0)
                tokens.remove(token.key);
        }
    }

    private class Token {
        public final Object key;
        public final ReentrantLock lock = new ReentrantLock();
        public int checkedOutCount = 1;

        public Token(Object key) {
            this.key = key;
        }
    }
}