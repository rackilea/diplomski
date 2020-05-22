Operation op;

lock.lock();
try {
    op = deque.pollLast(); // poll won't throw exception if there is no element
} finally {
    lock.unlock();
}

if (op != null) {
    op.perform();
}