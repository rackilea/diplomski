btnNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(listIncrement <= excersises.size()) {
            executeExercise(excersises, listIncrement); //next Exercise
            listIncrement++;
        }
    }
});