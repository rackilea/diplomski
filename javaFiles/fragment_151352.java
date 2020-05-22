DateTime initial = new DateTime( 1970, 1, 1, 22, 30, 0 );
DateTime dayUpdated = initial.withDate( 1980, 2, 3 );
DateTime timeUpdated = initial.withTime( 15, 20, 0, 0 );
// At this point, initial still contains 1970-1-1, 22:30
//                dayUpdated is 1980-2-3 22:30
//                timeUpdated is 1970-1-1 15:20