switch (am.getRingerMode())  {
case AudioManager.RINGER_MODE_VIBRATE:
    long[] pattern = new long[8];
    pattern[0] = 1000; // Wait one second
    pattern[1] = 950;  // Vibrate for most a second
    pattern[2] = 50;   // A pause long enough to feel distinction
    pattern[3] = 950;  // Repeat 3 more times
    pattern[4] = 50;
    pattern[5] = 950;
    pattern[6] = 50;
    pattern[7] = 950;
    vibe.vibrate(pattern, -1);
    break;
case AudioManager.RINGER_MODE_NORMAL:
    soundsOn(mp);
    break;
}