for(int row = 0 ; row < times.length - 1 ; row++) {
    for(int colFirst = 0 ; colFirst < times(row).length ; colFirst++) {
        for(int colSecond = 0 ; colSecond < times(row + 1).length ; colSecond++) {
            if(times[row][colFirst].equals(times[row+1][colSecond]))
                System.out.println(times[i][j + " = " +  times[i+1][j]);
        }
    }
}