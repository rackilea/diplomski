double EPSILON = .001;

    Iterator<Double> itr = set.iterator();
    Double prevVal = null;
    while(itr.hasNext()) {
        Double currentVal = itr.next();
        if (prevVal != null) {
            if(currentVal - prevVal < EPSILON ) {
                System.out.println(currentVal);
            }
        }
        prevVal = currentVal;
    }