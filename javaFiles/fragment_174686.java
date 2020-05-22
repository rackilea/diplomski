Duration dur = Duration.between(ago, now);

    this.seconds = dur.toSecondsPart(); // 40
    this.minutes = dur.toMinutesPart(); // 41
    this.hours = dur.toHoursPart(); // 1
    this.days = dur.toDaysPart(); // 0