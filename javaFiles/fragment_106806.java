Integer[] birthYear = new Integer[currentYear]; //currentYear is an int variable
int inc=1;
for(int i=0;i<currentYear;i++){
    birthYear[i]= inc;
    inc++;
}
JComboBox<Integer> birthYearBox = new JComboBox<>(birthYear);