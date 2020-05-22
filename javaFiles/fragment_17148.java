Duration dur = Duration.ofMillis(5007);
        String hmss = String.format("%02d:%02d:%02d:%03d", 
                                    dur.toHours(),
                                    dur.toMinutesPart(), 
                                    dur.toSecondsPart(), 
                                    dur.toMillisPart​());