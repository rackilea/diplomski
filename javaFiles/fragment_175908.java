public int compare(LeagueTableItem o1, LeagueTableItem o2){
     int diff = o2.getPoints() - o1.getPoints();
     if (diff == 0) {
        diff = o2.goalScored() - o1.goalScored();
     }
     return diff;
}