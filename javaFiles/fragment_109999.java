// Define timeout parameters
PusherOptions opt = new PusherOptions();
opt.setActivityTimeout((long)10000L);
opt.setPongTimeout((long)5000L);

// Create a new Pusher instance
Pusher pusher = new Pusher(PUSHER_KEY, opt);