//Outside the handler:
pool = Executors.newFixedThreadPool(poolSize);

// On message receipt
message = in.next();
pool.execute(new MessageHandler(message));