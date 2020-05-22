Queue<Long> attempts = loginFails.get(login);
if (attempts == null) {
    attempts = loginFails.putIfAbsent(login, new LinkedList<Long>());
    if (attempts == null) {
        attempts = loginFails.get(login);
    }
}
synchronized (attempts) {
    attempts.add(System.currentTimeMillis());
    if (attempts.size() > ATTEMPTS_TO_FREEZE) {
        attempts.remove();
    }
}