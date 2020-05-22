@SqlResultSetMapping( name="TripResults",
        entities={
            @EntityResult( entityClass=TripEntity.class ),
            @EntityResult( entityClass=CommercialTripEntity.class )
        }
    )
public class Foo {
   public void bogus() {
      Query q = em.createNativeQuery( 
        "select T.* " +
        "from Trip T join Itinerary I on (T.itinerary_id=I.id) " +
        "where I.launchDate between :start and :end " +
        "or ADDDATE(I.launchDate, I.equipmentPullDayOfTrip) between :start and :end",
        "TripResults" );

      q.setParameter( "start", range.getStart(), TemporalType.DATE );
      q.setParameter( "end", range.getEnd(), TemporalType.DATE );
   }
}