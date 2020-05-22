List<Long> attempts = loginFails.get(login);
if (attempts != null) {
    synchronized(attempts) {
        if (attempts.size() == ATTEMPTS_TO_FREEZE 
            && attempts.peek() > System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(TIME_FRAME_IN_MINUTES)) {
        //return some warning to user, that he exceeded number of attempts
        }
    }
}