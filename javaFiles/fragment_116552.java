int L0=0,L1=0,L2=0,L3=0,L4=0;
    List<Integer> marks = Arrays.asList(45, 66, 84, 89);
    for(int i = 0; i < marks.size(); i++){
        if (marks.get(i)<50){
            L0=L0+1;}
        else if ((marks.get(i)>=50) && (marks.get(i)<60)){
            L1=L1+1;}
        else if ((marks.get(i)>=60) && (marks.get(i)<70)){
            L2=L2+1;}
        else if ((marks.get(i)>=70) && (marks.get(i) < 80)){
            L3=L3+1;}
        else if ((marks.get(i)>=80) && (marks.get(i)< 100)){
            L4=L4+1;}}
    int[] level= new int [5];
    level[0]=L0;
    level[1]=L1;
    level[2]=L2;
    level[3]=L3;
    level[4]=L4;


    final JLabel analyzeoutput = new JLabel();
    analyzeoutput.setText("Numbers at Level 4:" + level[4]+ "\nNumbers at Level 3:" +
            level[3]+ "\nNumbers at Level 2:" + level[2]+ "\nNumbers at Level 1:" + level[1]+ "\nNumbers at Level R:" + level[0]);
    }