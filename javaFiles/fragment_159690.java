// Method called in other parts of the program. 
private boolean checkNum(int x, int y, int limit){ 

        int num = 0;
        num = checkNum(x,y,num,limit,count); // I think the recursive methods following this one are carried out after the statement on the next line. That is the cause of the issue.

        return (num <= limit);
}


//Recursive method called be previous one and itself.
private int checkNum(int x, int y, int num, int limit,int count){

        if (num > limit) {
            return num;
        }

        if ((grid[x][y] == 3) || (grid[x][y] == 1)) {
            return num;
        }




        grid[x][y] = 3;
        System.out.println(num);
        num++;



        num = checkNum(x + 1,y,num,limit,count);
        num = checkNum(x - 1,y,num,limit,count);
        num = checkNum(x,y + 1,num,limit,count);
        num = checkNum(x,y - 1,num,limit,count);

        return num;
}