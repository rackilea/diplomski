public int dequeue(){
         if (out.isEmpty())
         {
          while(!in.isEmpty())
            {
                out.push(in.pop());
            }
          }
        int outVar = out.pop();
        while(!out.isEmpty())
            {
                in.push(out.pop());
            }
         return outVar;
    }