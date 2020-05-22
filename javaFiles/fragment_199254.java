private void calculateSuperMemo2Algorithm(FlashCard card, int quality) {

    if (quality < 0 || quality > 5) {
        // throw error here or ensure elsewhere that quality is always within 0-5
    }

    // retrieve the stored values (default values if new cards)
    int repetitions = card.getRepetitions();
    float easiness = card.getEasinessFactor();
    int interval = card.getInterval();

    // easiness factor
    easiness = (float) Math.max(1.3, easiness + 0.1 - (5.0 - quality) * (0.08 + (5.0 - quality) * 0.02));

    // repetitions
    if (quality < 3) {
        repetitions = 0;
    } else {
        repetitions += 1;
    }

    // interval
    if (repetitions <= 1) {
        interval = 1;
    } else if (repetitions == 2) {
        interval = 6;
    } else {
        interval = Math.round(interval * easiness);
    }

    // next practice 
    int millisecondsInDay = 60 * 60 * 24 * 1000;
    long now = System.currentTimeMillis();
    long nextPracticeDate = now + millisecondsInDay*interval;

    // Store the nextPracticeDate in the database
    // ...
}