int draftPick(int[] teams, int target) {

    int targetTeam = teams[target];
    int finalPick = 0;

    for(int i = 0; i <= target; i++) {

        int team = teams[i];

        if(team > targetTeam) team = targetTeam;

        finalPick += team;

    }

    for(int i = (target + 1); i < teams.length; i++) {

        int team = teams[i];

        if(team > targetTeam - 1) team = targetTeam - 1;

        finalPick += team;

    }

    return finalPick;

}