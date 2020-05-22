your isDateValid method can be modified as follow for list

    public  boolean isDateValid(List<String> list ) {
        //return true if list is null or empty
        if(list==null || list.isEmpty())
            return true;
        List<SimpleDateFormat> knownPatterns = new ArrayList<>();
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        knownPatterns.add(new SimpleDateFormat("MM/dd/yyyy"));
        //counter to keep counting valid dates
        int validCount=0;
        boolean flag=false;
        Iterator<String> itr=list.iterator();
        String date;
        while(itr.hasNext()){
            date=itr.next();
        for (SimpleDateFormat pattern : knownPatterns) {
            try {
                pattern.parse(date);
                validCount++;
                flag=true;
               break;               
            } catch (ParseException e) {
                continue;
            }
        }
        if(!flag)
            itr.remove();
        else
            flag=true;
        }
        //if there were valid dates in list return true else return false
        return validCount>0?true:false;
    }