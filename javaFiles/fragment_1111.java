enum GuideView {
    SEVEN_DAY,
    NOW_SHOWING,
    ALL_TIMESLOTS
}

// Working on the assumption that your int value is 
// the ordinal value of the items in your enum
public void onClick(DialogInterface dialog, int which) {
    // do your own bounds checking
    GuideView whichView = GuideView.values()[which];
    switch (whichView) {
        case SEVEN_DAY:
            ...
            break;
        case NOW_SHOWING:
            ...
            break;
    }
}