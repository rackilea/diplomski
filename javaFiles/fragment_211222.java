public static void main(String[] args) {
    reduceByOne(1) => { // call of reduceByOne with n==1
        if( 1>=0 )  {
            reduceByOne(0) => { // call of reduceByOne' with n'==0
                if(0>=0) {
                    reduceByOne(-1) => { // call of reduceByOne'' with n''==-1
                        if(-1==0) // does nothing
                        System.out.println(-1)
                    } // return back to reduceByOne'
                }
                System.out.println(0)
            } // return back to reduceByOne
        }
        System.out.println(1);
    } // return back to main
}