while(!allRoutineComplete){
            for (Routine routine : routineList) {
                if(!(routine.isBlocked()) && !(routine.isFinished())) {
                    routine.run();
                    if(routine.isFinished()){
                        completedRoutineNumber++;
                    }
                    if(completedRoutineNumber==routineList.size()){
                    allRoutineComplete=true;
                    }
                }
            }
            for (Routine routine : routineList) {
                routine.updateStatus();
            }
}