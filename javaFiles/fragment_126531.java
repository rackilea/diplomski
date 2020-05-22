for(String line : fileToArray) {
    Matcher xTimeSeeker = rinngerPat.matcher(line);
    if(xTimeSeeker.find()) {
       xTimesRing = xTimeSeeker.group(1);
       int xTimeSeekerInt = Integer.parseInt(xTimesRing);
       System.out.println(xTimeSeekerInt);
    }
}