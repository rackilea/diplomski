if (personList[x] instanceof TeamLeader){
    TeamLeader teamLeader = (TeamLeader) personList[x];
    System.out.printf("-20s %3i %10i %10s\n",
        teamLeader.getName(), teamLeader.getAge(), 
        teamLeader.getTeamSize(), " ");
}