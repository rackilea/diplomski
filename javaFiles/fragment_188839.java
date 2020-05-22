this.outstream = Channels.newChannel(outstream);
try {
    outstream.write(message);
}
catch(AsynchronousCloseException e) {
    System.out.println("Another thread closed the stream while this one was blocking on I/O!");
}
catch(ClosedByInterruptException e) {
    System.out.println("This thread has been interrupted while blocking on I/O!");
}