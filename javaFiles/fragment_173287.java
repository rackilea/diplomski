AtomicInteger time = new AtomicInteger();
//whenever you want to reset it:
time.set(0);

AtomicBoolean isPlaying = new AtomicBoolean();

//when user clicks "start":
isPlaying.set(true);
//when user wins or clicks "reset"
isPlaying.set(false);

//your timer task will look something like this:
public void run() {
    if (isPlaying.get()) {
        int currentTime = time.incrementAndGet();
        int hours = (int) currentTime / 3600;
        int remainder = (int) currentTime - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;
        timeTaken.setText(String.format("%02d:%02d:%02d",hours,mins,secs));
    }
}