public void findavg(Student []a) {
    int []sum = new int [5];
    for(Student stu: a) {
        for(int i=0; i<5; i++) {
            sum[i] += stu.getScores(i);
        }
    }
    for(int i=0; i<5; i++) {
        avgscores[i] = sum[i] / a.length;
    }
}