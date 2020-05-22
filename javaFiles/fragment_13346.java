public String getTS() {
    StringBuilder sb = new StringBuilder();
    for(int a=0;a<testScore.length;a++) {
        sb.append(testScore[a]+" ");
    }
    return sb.toString();
}