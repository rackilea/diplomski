public void playTune(String eventTune, Player p)
{
    /*Creates sp if it is null (When it is null, we know that there is no
    RadioSongPlayer object referenced by sp)*/
    if (Methods.getSongPath(eventTune).exists()) && sp == null)
    {
            Song s = NBSDecoder.parse(Methods.getSongPath(eventTune));
            sp = new RadioSongPlayer(s);
            sp.setAutoDestroy(true);
            sp.addPlayer(p);
            sp.setPlaying(true);
    }
    else
    {
            notFound(eventTune);
    }
    //Now that sp is not null, we know that it references a SongPlayer object, that is,
    //the object we just created in the first if statement
    if(sp != null){ /
        //sp was created
        //Use sp
    }
}