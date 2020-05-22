@Override
public void run() {
    Database db = new Database();
    Instant startTime = Instant.now();

    while (!exit) {
        try {
            Long id = db.getUpdate(1105349L);
            if (id != null) {
                db.deleteUpdate(id);
            }

            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);

            System.out.println(duration.getSeconds());
            if (duration.getSeconds() >= 30 || id != null) {
                System.out.println("CALLED!");
                startTime = Instant.now();
            }

            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}