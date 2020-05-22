private void combineInfo() {
for(int i = 0; i < monsterList.size(); i++){
    //add only if name is non empty, ID is not negative and level is below 100
    if(!(names[i].isEmpty() || IDs[i]<0 || levels[i]>100))
    monstersToAdd.add("" + names[i] + "," + IDs[i] + "," + levels[i]);
}