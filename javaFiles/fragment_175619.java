MyAlgorithm(A,0,3) 
    (l < r : true)
     m = (0+3)/2=1
     MyAlgorithm(A,0,1) 
            (l < r : true) 
            m = (0+1)/2=0
            MyAlgorithm(A,0,0) 
                (l < r : false) return

            loop from l=0 to r=1
            System.out.println(A[0]);
            System.out.println(A[1]);

            //MyAlgorithm(A,m+1,r)
            MyAlgorithm(A,1,1) 
                (l < r : false) return

    loop from 1=0 to r=3
    System.out.println(A[0]);
    System.out.println(A[1]);
    System.out.println(A[3]);
    System.out.println(A[4]);

    //MyAlgorithm(A,m+1,r)
    MyAlgorithm(A,2,3)
        (l < r : true)
        m=(2+3)/2 = 2
        MyAlgorithm(A,2,2)
            (l < r : false) return

    loop from 1=2 to r=3
    System.out.println(A[2]);
    System.out.println(A[3]);

    MyAlgorithm(A,3,3)
            (l < r : false) return      
return