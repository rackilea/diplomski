lock.lock();
try {
  while (count == items.length)
    notFull.await();
  items[putptr] = x;
  if (++putptr == items.length) putptr = 0;
  ++count;
  notEmpty.signal();
} finally {
  lock.unlock();
}