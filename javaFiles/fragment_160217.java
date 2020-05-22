for(int i = 0; i < track.size(); i++)
{
       if(!track.remove(track.get(i)))
       {
              Logger.Add("MIDI Event not removed");
       }
}