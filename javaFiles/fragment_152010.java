int x = ...; //x is some int
int y = ...; //y is some int

Coord coordOriginal = new Coord(x, y);
//coordOriginal points to a new Coord object. Let's call it "A".

Coord coordCopy = coordOriginal.copy();
//coordCopy points to to a new Coord object.  Let's call it "B".
//coordOriginal still points to Coord object "A".