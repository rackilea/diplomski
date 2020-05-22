public boolean equals(Clock another_clock) {
    // Check if 'this' is equal to 'another_clock'

    // 1. If you're checking if the pointer is the same
    return another_clock.equals(this);

    // 2. If you're checking if time is the same (You probably need to create getter/setter methods or change privacy for these fields)
    return another_clock.hours == this.hours &&
        another_clock.minutes == this.minutes &&
        another_clock.seconds == this.seconds;
}