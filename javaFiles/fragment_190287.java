write requester thread:
  ioloop.submit(buffer[]{msgheaderbuf, msgbodybuf}, sock);
selector thread (ioloop):
  submit(buffer[] bufs, socket sock):
    queue.enqueue(bufs);
    selector.register(sock, WRITABLE);
    selector.wakeup();