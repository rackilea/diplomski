PeriodFormatter formatter = new PeriodFormatterBuilder()
        .appendPrefix("Day:", " Days:").appendDays()
        .appendPrefix(" Hour:", " Hours:").appendHours()
        .appendPrefix(" Minute:", " Minutes:").appendMinutes()
        .appendPrefix(" Second:", " Seconds:").appendSeconds()
        .toFormatter();