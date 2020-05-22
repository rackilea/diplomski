for( int n = 1; n <= 100000; n++ ){       // 100000 - Just for argument sake
    Thread t = new Thread(new Runnable(){
        void run(){
            for (int i=0;i<=1000000;i++){     
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