StringBuilder sb = new StringBuilder();
for(int i = 0; i< 9; i++) {
    for(int j = 0; j< 9; j++)
    {
        sb.append(p[i][j]);
        sb.append(" ");
    }
    // You maybe want sb.append("\n") here, if you want it on separate lines.
}    
String str = sb.toString();