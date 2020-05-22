// If we're close enough to the next note, just use the next note. 
if (pitches >= 16380)
{
   pitches = 0;
   semitone += 1;
   if (semitone == 12)
   {
       octave += 1;
       semitone = 0;
   }
}