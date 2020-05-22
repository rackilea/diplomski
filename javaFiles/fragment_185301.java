public ArrayList<FlightObject> processResults(ArrayList<FlightObject> list) {
    for (Iterator<FlightObject> iter = list.iterator(); iter.hasNext();) {
        FlightObject fo = iter.next();   
        if (fo.status == null) {
            iter.remove();            
        }
    }
    return list;
}