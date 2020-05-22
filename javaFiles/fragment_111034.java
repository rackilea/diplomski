totalDuration = 0;
for (i = 0; i < 1000; ++i)
    startMeasure = now();
    algorithm();
    endMeasure = now();
    duration = endMeasure - startMeasure;
    totalDuration += duration;
}

//...

TRIALS_COUNT = 1000;
startMeasure = now();
for (i = 0; i < TRIALS_COUNT; ++i)
    algorithm();
}
endMeasure = now();
 duration = endMeasure - startMeasure / TRIALS_COUNT;