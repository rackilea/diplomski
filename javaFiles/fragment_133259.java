class ProcessComparator implements Comparator<Process>{
    public int compare(Process p1, Process p2){
       if(p1.getStartTime() < p2.getStartTime()) return -1;
       if(p1.getStartTime() > p2.getStartTime()) return 1;
       //If here, p1.startTime == other.startTime
       if(p1.getDuration() < p2.getDuration()) return -1;
       if(p1.getDuration() > p2.getDuration()) return 1;
       return 0;
    }
}