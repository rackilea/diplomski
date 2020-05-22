String myCurrentID = "";
String strPreviousID = "";

while (moreRecordsAvailable)
{
    myCurrentID = resulset.getString("ID");
    if (!myCurrentID.equals(strPreviousID ))
    {
        // If the previous and current are different, then add both artist and picture objects
         strPreviousID =        myCurrentID ;
         Artist artist = new Artist();
         artist.setId(resulset.getString("a.id"));
         ........
         Pic pic = new Pic();
         pic.setIdArtist(resulset.getString("a.id"));
         pic.setUrl(resulset.getInt("p.picUrl"));
         .....
        artist.setPic(pic );
    }
    else
    {
        // If previous and current is same, then add only pictures object. Need not add artist object here.
        Pic pic = new Pic();
        pic.setIdArtist(resulset.getString("a.id"));
        pic.setUrl(resulset.getInt("p.picUrl"));
    }

}