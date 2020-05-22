public class Test{
  public static void main(String[] args){

    //create two MergeArrays objects
    MergeArrays obj1 = new MergeArrays(1, 5, 10, 15, 20);
    MergeArrays obj2 = new MergeArrays(3, 7, 13, 18, 23);

    //get answer from arrange()
    int[] answer = obj1.arrange(obj2);

    //print the answer
    for (int i = 0; i < answer.length; i++){
     System.out.println(answer[i]); 
    }
  }
}


public class MergeArrays
{
    int a1[];int size;

    //used varargs here to send in the array
    MergeArrays(Integer... args)
    {
      size=args.length;
      a1=new int[size];

      //initialize 
      for (int i = 0; i < size; i++){
       a1[i] = args[i]; 
      }
    }

    int[] arrange(MergeArrays obj)
    {
        int answer[]=new int[obj.a1.length+a1.length];
        int i = 0; //initialize
        int j = 0; //initialize
        int k=0;
        while(i<size && j<obj.size)
        {
          if(a1[i]>obj.a1[j])
          {
              answer[k++]=obj.a1[j++];
          }
          else 
          {
              answer[k++]=a1[i++];
          }
        }
        while(i<size)
        {
            answer[k++]=a1[i++];
         }
        while(j<size)
        {
            answer[k++]=obj.a1[j++];
        }

        return answer; //add this
    }
}