YourTrnCtx ctx = startNewTransaction();
registerContextToThread(ctx);
YourBean b = new YourBean();
injectResources(b);
b.start();
b.service();
b.end();
commitTransaction(ctx);