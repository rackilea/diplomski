System.out.println("Enter no. of subjects");
int subNo = getInt(br);

for(int i=0; i<marksArray.length; i++) {
    System.out.println("Enter marks for subject " + (i+1));
    marksArray[i] = getInt(br);
}