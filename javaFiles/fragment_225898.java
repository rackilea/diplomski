int numExercises = 1;
Exercise [] exercises = new Exercise[numExercises];
exercises[0] = new MatheMagic();
for (Exercise exercise : exercises) {
    exercise.execute();
}