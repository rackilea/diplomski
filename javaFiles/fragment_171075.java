// declare this variables as attributes in you class
val handler = Handler()
val runnable = Runnable {
    // Call something when it finishes
}
handler.postDelayed(runnable, 60_000) // Do something after 60 seconds


// and if you want to cancel the timer, you can cancel it this way
handler.removeCallbacks(runnable)