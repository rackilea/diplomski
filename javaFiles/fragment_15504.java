p = pb.start()
// Everything in-between removed
if(p.waitFor(10l, TimeUnit.MILLISECONDS)) {

// Now this code is not processed in case of time out
}