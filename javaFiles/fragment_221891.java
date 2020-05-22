List<Leg> legs = new ArrayList<Leg>(legdata.length);
for (Legform ld: legdata){
   Leg leg = new Leg();
   leg.securityType = ld.getSecurityType();
   legs.add(leg);
}