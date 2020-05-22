int common = 0;
int commonIndex = -1;
for(int i = 0; i < fams.length; i++) {
    if(common < fams[i]) {
        common = fams[i];
        commonIndex = i;
    }
}