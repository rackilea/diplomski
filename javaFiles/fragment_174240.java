public static void main (String[] args) {
    BufferedReader bf=null;

    try{
         bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println ("1..case1 | 2..case2");
        int ch=Integer.parseInt(bf.readLine());       //user input for switch
        System.out.println (ch);

        switch(ch){                  //userinput ch variable switch in case
            case 1 :
                String data=bf.readLine();

                System.out.println(data);
                break;
            case 2 :            
                System.out.print ("Enter Key ");
                String key=bf.readLine();

                System.out.println(key);
                break;
            default :
                System.out.println ("wrong choice");        
      }
    } catch(IOException e){
        System.out.println ("io error");
        e.printStackTrace();
    }
    finally
    {
        try {
            bf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    }