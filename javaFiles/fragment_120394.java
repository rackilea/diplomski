...
Thread t = new Thread(new Runnable() {
    ...
});
t.start();

// wait for the 'Jsoup thread' to complete before continuing
t.join();

for (int i = rawHours.size() - 1; i >= 0; i--) {
    hrrrLabels[23 - i] = rawHours.get(i);
}
...