@Override
    public boolean equals(Object obj) {
        if(obj instanceof Airport) {
            if(this.airportCode.equals(((Airport) obj).getAirportCode())) {
                String[] gs = ((Airport) obj).getGates();
                Arrays.sort(gates);
                Arrays.sort(gs);
                //Compare gates, if not equal, return false, else true
                return gatesAreEqual;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }