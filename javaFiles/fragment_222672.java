if (colors != null && colors.length > 0) {
    // Default streaks to 1, and colors to the first color
    int longestStreak = 1;
    int longestStreakColor = colors[0];
    int currStreak = 1;
    int currStreakColor = colors[0];

    // Start at index 1 since we already stored the first color in currStreakColor
    for (int i = 1; i < colors.length; i++) {
        // If the color is the same as the previous color or is green,
        // increment the currStreak
        if (colors[i] == currStreakColor || colors[i] == Color.GREEN.value) {
            currStreak++;
        } else {
            // If the color is different and the streak that just ended was
            // longer than the previous longest streak, update longestStreak
            // and longestStreakColor
            if (currStreak > longestStreak) {
                longestStreak = currStreak;
                longestStreakColor = currStreakColor;
            }
            // Reset currStreak
            currStreak = 1;
        }
        // Set currStreakColor to the current color if it isn't green
        if (colors[i] != Color.GREEN.value) {
            currStreakColor = colors[i];
        }
    }
}

// If we ended on a streak longer than the previous longest streak, update
// longestStreak and longestStreakColor
if (currStreak > longestStreak) {
    longestStreak = currStreak;
    longestStreakColor = currStreakColor;
}