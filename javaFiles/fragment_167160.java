class ABC{
    public int customerperminute(){
        Random R = new Random();
        int r = R.nextInt(4-0);
        if (r==0||r==1){
            return 0;
        }
        if (r==2){
            return 1;
        }
        else {
            return 2;
        }    
    }
    public static int customerperminuteStat(){
        Random R = new Random();
        int r = R.nextInt(4-0);
        if (r==0||r==1){
            return 0;
        }
        if (r==2){
            return 1;
        }
        else {
            return 2;
        }    
    }
}