// assume a class called GravMass which has Mass, position, and momentum
List<GravMass> gravMassList = new ArrayList<GravMass>();

// fill your list

for(int i = 0; i < gravMassList.size() - 1; i++) {
    GravMass gravMass1 = gravMassList.get(i);
    int mass1 = gravMass1.getMass();
    for(int j = i + 1; j < gravMassList.size(); j++){
        GravMass gravMass2 = gravMassList.get(j);
        int mass2 = gravMass2.getMass();
        //getting mass and position from both
        //calculations here}
    }
}