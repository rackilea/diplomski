for(int i=0;i<42;i++){
        counter=1; // to keep track about on which TOKEN the code is working
        System.out.println("Starting line"+i);
        st2=new StringTokenizer(raf1.readLine(),",");
            while(st2.hasMoreTokens()){
                boolean b = is_there(array2,counter);
                if(!b){
                    st2.nextToken();
                }else{
                    String s2=st2.nextToken();
                    raf2.writeBytes(s2 + ",");
                }
                counter++;
            }
            raf2.writeBytes("\r\n");         //next line!
        }