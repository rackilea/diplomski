DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a", Locale.ROOT);
        try {
            LocalTime lt = LocalTime.parse(startTime, timeFormat);
            startTime = lt.format(timeFormat);
            System.out.println(startTime);
        } catch (DateTimeParseException e) {
            System.out.println("Not a valid time. Please use this format (HH:MM AM)");
        }