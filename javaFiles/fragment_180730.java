class WaterLog{

private Integer size;
private Integer max ;
private ArrayList<Integer> theLog; //parameterize your lists
private int counter = 0;

public WaterLog(Integer windowSize, Integer maxEntry) //this is the behavior you were    looking for
{
this.size = windowSize;
this.max = maxEntry;
theLog = new ArrayList<Integer>(windowSize);
}

public void addEntry(Integer newEntry) throws SimulationException {

theLog.add(0, newEntry);
counter++;

}

public Integer getEntry(Integer index) throws SimulationException {

if (theLog.isEmpty() || theLog.size() < index) { //Java is case sensitive
    return null;
}
return theLog.get(index);

}

public Integer variation() throws SimulationException {

int old, recent = 0;
recent = theLog.get(0);
old = theLog.get(theLog.size()-1); //again, watch case, also size is a method
return recent-old;
}

public Integer numEntries() {

return counter;

}

}