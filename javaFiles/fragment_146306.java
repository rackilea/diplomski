long[] times = {360000, 3000, 4350, 36300, 0};
for (long time : times) {
    String result = String.format("%d:%02d",
            TimeUnit.SECONDS.toMinutes(time),
            TimeUnit.SECONDS.toSeconds(time) % TimeUnit.MINUTES.toSeconds(1));
    System.out.println(String.format("%d : %s", time, result));
}