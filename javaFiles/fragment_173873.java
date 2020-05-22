List<Tracks>  trackLst = ....;
List<SensorEvent>  eventLst = ....;

// Make the 2 lists equal in length
while ( trackLst.size() > eventLst.size() )  eventLst.add( null );
while ( eventLst.size() > trackLst.size() )  trackLst.add( null );

for ( int e = 0; e < eventLst.size(); e++ )
{
    for ( int i = 0; i < trackLst.size(); i++ )
    {
        SensorEvent  evt = eventLst.get( i );

        if ( evt != null )
        {
            Track  trk = trackLst.get( i );

            if ( trk == null )  trk = new Track();

            trk.update( evt );
        }
    }

    eventLst.add( eventLst.remove(0) );
}