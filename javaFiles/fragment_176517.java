while(scan.hasNext()){
           str = scan.next(); //inputting a character
           if(str.equals("exit")) // input `exit` and loop will break
               break;
           else 
           st.push(str); // else it will keep adding elements in stack
           }