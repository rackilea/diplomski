Object sharedMonitor = new byte[0]

// In your auto-updater and other threads
synchronised(sharedMonitor ) {

}