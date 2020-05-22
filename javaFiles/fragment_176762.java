for( int n = 1; n <= 16; n++ ){  
    Thread t = new Thread(new Runnable(){
        void run(){
            for (int i=0;i<=62500;i++){     // 1000000 / 16 = 62500
                for (int j=0;j<=10000;j++){
                    for (int k = 0;k<=10;k++){
                        sum++;  
                    }
                }
            }
        }
    });
    t.start();
}