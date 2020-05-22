Array<Body> bodies=new Array<Body>();

world.getBodies(bodies);

for (Body body: bodies){
     world.destroyBody(body);
}