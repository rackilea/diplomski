for(int j=1;j<=n/2;j++) {
    if(flipandcheck(new StringBuffer(in),j)) {
            output=j+1;
            break;
    }
}