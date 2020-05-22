ReferencedEnvelope env = fr.getMapPane().getDisplayArea();
double x,y;//new centre
double w2 = env.getWidth()/2.0;
double h2 = env.getHeight()/2.0;
Coordinate c = new Coordinate(x,y);
ReferencedEnvelope renv = new ReferencedEnvelope(c.x-w2,c.x+w2,c.y-h2,c.y+h2,env.getCoordinateReferenceSystem());