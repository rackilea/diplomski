PrintWriter printWriter= new PrintWriter(new File("out4.txt"));
try {
    boolean first = true;
    for(int row=1;row<data.length;row++){
        String playerName=data[row][0].toLowerCase();
        if(playerName.indexOf(player)!=-1){
            String[] fields=data[0];
            String[] values=data[row];
            if (first)
                first = false;
            else
                printWriter.println();
            for (int i=0;i<fields.length;i++){
                printWriter.printf("%21s : %s%n",fields[i],values[i]);
            }
        }
    }
} finally {
    printWriter.close();
}