static int[] arr = {1,2,3,4,5};
public static int[] method(int[] arr){
    List<Integer> list = new ArrayList<Integer>();
    for (int i=0; i<arr.length; i++) {
        list.add(arr[i]);
    }
    list.add(6);                
    int[] ret = new int[list.size()];
    for (int i=0; i <ret.length; i++)                   
        ret[i] = list.get(i).intValue();        
    return ret;
}
public static void main(String args[])
{
    arr = method(arr);      
    for(int i=0;i<arr.length;i++)
    {
        System.out.println(arr[i]);
    }
}