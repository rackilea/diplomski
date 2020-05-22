for(int i =0 ; i < fileToArray.size(); i++){
        String frisk = fileToArray.get(i).toString();

        Matcher eventSeeker = eventPat.matcher(frisk);
        while(eventSeeker.find()){
            typeOfEvents.add(eventSeeker.group());
        }

        Matcher timeSeeker = timePat.matcher(frisk);
        while(timeSeeker.find()){
            typeOfTime.add(timeSeeker.group());
        }
    }