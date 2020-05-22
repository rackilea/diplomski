static class DayCoverage {

    private Map<LocalTime, LocalTime> cover = new HashMap<>();

    public void addIntervall(LocalTime start, LocalTime end) {
        if(end.isBefore(start)){
            this.cover.put(end, start); 
        } else {
            this.cover.put(start, end);
        }
    }

    public boolean isComplete() {
        if(this.cover.isEmpty()){
            System.err.println("Coverage empty.");
            return false;
        }

        Set<LocalTime> startTimes = this.cover.keySet();
        List<LocalTime> sortedStartTimes = new ArrayList<>(startTimes);
        Collections.sort(sortedStartTimes);

        LocalTime first = sortedStartTimes.get(0);
        if(! LocalTime.MIN.equals(first)){
            System.err.println("Coverage does not start with 00:00.");
            return false;
        }

        LocalTime lastEnd= LocalTime.MIN;
        for (LocalTime start : sortedStartTimes) {
            if(lastEnd.plus(1, ChronoUnit.MINUTES).isBefore(start)){
                System.err.println("Missing coverage between: " + lastEnd + " and " + start);
                return false;
            }
            lastEnd = this.cover.get(start);
        }

        if(LocalTime.MAX.truncatedTo(ChronoUnit.MINUTES).isAfter(lastEnd)){
            System.err.println("Missing coverage between: " + lastEnd + " and 23:59");
            return false;
        }

        return true;
    }

}