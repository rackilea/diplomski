final int sublistSize =  programTrackers.get(position).getProgramTrackers().size();
for (int i = 0; i < sublistSize; i++){
  if (programTrackers.get(position).getProgramTrackers().get(i).isProgramExerciseFinished()){
        isFinished = true;
    }
}