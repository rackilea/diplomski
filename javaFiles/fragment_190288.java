write requester thread:
  ioloop.submit(buffer[]{msgheaderbuf, msgbodybuf}, sock);
selector thread (ioloop):
  submit(buffer[] bufs, socket sock):
    size = sock.write(bufs);
    while (!bufs.empty() && !bufs[0].remaining()): bufs.pop_front();
    if (bufs.empty()) return;

    queue.enqueue(bufs);
    selector.register(sock, WRITABLE);
    selector.wakeup();