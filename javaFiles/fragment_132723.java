/**
 * The number of sockets in the connection backlog. Default 5;
 * increase if you expect high connection rates.
 * @param backlog The backlog to set.
 */
public void setBacklog(int backlog) {
    Assert.isTrue(backlog >= 0, "You cannot set backlog negative");
    this.backlog = backlog;
}