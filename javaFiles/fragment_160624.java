class test_array {
//test_array class  

    public static void main(String args[])
    {
            int[] a={4,2,99,9,-1,0};           
            int small=a[0];

        for (int i=1;i<a.length;i++)               
        {                                      
            if(a[i]<small)
            {                                             
                small=a[i];
            } 
        }

        System.out.println(small);       
    }   
}