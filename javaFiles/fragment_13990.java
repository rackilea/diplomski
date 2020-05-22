int sum = 0;
    for(int i = 0; i <=dailyList.size(); i++) {
        dailyExerciseID = dailyList.get(i).getDcExerciseId();
        dailyExerciseName = dailyList.get(i).getDcexerciseName();
        points = dailyList.get(i).getPoints();
        sum = sum + points;
    }