if (pitches >= 12288)
{
        int diff = 16384-pitches;
        int applieddiff = 8192-diff;
        pitches = applieddiff;
        semitone += 1;
        if (semitone == 12)
        {
            octave += 1;
            semitone = 0;
        }
}