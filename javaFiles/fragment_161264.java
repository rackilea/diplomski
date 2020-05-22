int common = 0;
for(int i = 0; i < fams.length; i++) {
    if(common < fams[i]) {
        common = fams[i];
    }
}
// at this point, common would hold the most common number of kids