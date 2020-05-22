// Get your meetup by identifier
final Meetup meetup = entityManager.find( Meetup.class, meetupId );

// cleanup the match associations with meetup
entityManager.createQuery( "FROM Match WHERE meetup = :meetup")
      .setParameter( "meetup", meetup )
      .getResultList()
      .forEach( match -> { match.setMeetup( null ); } );

// remove meetup
entityManager.remove( meetup );