Coordinate[] coords = {
   new Coordinate(3093, 3630 ), new Coordinate(3095, 3632), new Coordinate(3098, 3633),
   new Coordinate(3101, 3633 ), new Coordinate(3104, 3631), new Coordinate(3106, 3629), 
   new Coordinate(3107, 3627), new Coordinate(3108, 3624), new Coordinate(3109, 3620),
   new Coordinate(3108, 3617), new Coordinate(3106, 3614), new Coordinate(3102, 3613),
   new Coordinate(3099, 3613), new Coordinate(3097, 3613), new Coordinate(3093, 3614),
   new Coordinate(3090, 3617), new Coordinate(3087, 3619)
};

ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

int random = Misc.random(coords.length - 1);

if (getPlayersCount() < coords.length) {
    Coordinate coord = new Coordinate(coords[random].getLatitude(), coords[random].getLongitude());
    if (coordinates.contains(coord)) {
        random = Misc.random(coords.length - 1);
    }
    else {
        handler.move(coords[random].getLatitude(), coords[random].getLongitude(), 0);
        coordinates.add(coords[random]);
    }
}
else {
    random = Misc.random(coords.length - 1);
    handler.move(coords[random].getLatitude(), coords[random].getLongitude(), 0);
}