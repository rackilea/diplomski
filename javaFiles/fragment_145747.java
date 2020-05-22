int start=0; 
    String[] rows=new String[10];
    int colCount=0;
    int rowCount=0,i;
    String str="";
    String received="1 15/8/2012 15:00 palak paneer 2 200 dam aaloo 2 100 a a a 3 4";
    String splittedStrs[]=received.split("[a-z]");
    String header=splittedStrs[0].trim(); 
    received=received.substring(header.length()+1);
    boolean prev=false;
    for ( i = 0; i < received.length(); i++) {
        char c=received.charAt(i);
        if(c==' '){ 
            if(str.matches("\\D+")){                        
                prev=true; 
                str="";
            }
            else{
                if(prev==true){ 
                    colCount++;
                    if(colCount==3){
                        rows[rowCount]=received.substring(start,i);
                        rowCount++; 
                        start=i+1;
                        colCount=0;
                    } 
                }
                colCount++;
                if(colCount==3){
                    rows[rowCount]=received.substring(start,i);
                    rowCount++;
                    start=i+1;
                    colCount=0;
                }
                prev=false;
                str="";
            }
        } 
        else{
            str=str.concat(c+"");
        }
    }
    rows[rowCount]=received.substring(start,i);

    System.out.println("Header ="+header);
    for ( i = 0; i <= rowCount; i++) {
        System.out.println(rows[i]);
    }