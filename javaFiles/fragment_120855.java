import play.api.libs.concurrent.Execution.Implicits.defaultContext
// Delete a file after 10 seconds
val cancellable = system.scheduler.scheduleOnce(10.seconds) {
  file.delete()
}

// Print the message "Hi" every 30 seconds, starting after 5 seconds 
val cancellable = system.scheduler.schedule(5.seconds, 300.seconds) {
  log("Hi")
}