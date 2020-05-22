Timer timer = new Timer();
    int delayMs = 1000; // check time every one second
    long timeToStop;
    try {
        timeToStop = new SimpleDateFormat( "DD.MM.YYYY HH:mm" ).parse( "16.11.2014 20:00" ).getTime(); // GMT time, needs to be offset by TZ
    } catch (ParseException ex) {
        throw new RuntimeException( ex );
    }
    timer.scheduleAtFixedRate( new TimerTask() {
        @Override
        public void run() {
            if ( System.currentTimeMillis() < timeToStop ) {
                System.out.println( "Do something every " + delayMs + " milliseconds" );
            } else {
                timer.cancel();
            }
        }

    }, 0, delayMs );