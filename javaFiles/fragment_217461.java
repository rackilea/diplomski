getDistance(MESSAGES_RECEIVED);
    for(Message m : MESSAGES_RECEIVED){

        float dist = m.getDistance();
        int distMax = Integer.valueOf(VALUE_PREF_RADIUS_GEO_FENCING);

        if(dist < distMax){
            MESSAGES_DISPLAYED.add(m);
        }
    }

}