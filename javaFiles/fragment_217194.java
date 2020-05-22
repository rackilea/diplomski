int infectedConnections = 0;

if (getConnections() != null) {
    for (Agent a : this.getConnections())
    {
        if(a instanceof Person) {
            Person p = (Person) a;

            if (p.IsCurrentlyInfected()) {
               infectedConnections++;
            }
        }
    }
}
return infectedConnections;