String s = new String("I love my school. I love to play basketball. It is lovely weather. Love is life.").toLowerCase();
    System.out.println(s);
    int i = 0;
    int count = 0;
    System.out.print("Counting love:");
    while(i != -1)
    {
      i = s.indexOf("love");
      if(i != -1){
        count++;
        s = s.substring(i+1);
        System.out.print(count+" ");
      }
    }
    System.out.println("The word \"love\" appears "+count+" times.");