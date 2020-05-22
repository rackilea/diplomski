int siffra = 153;

 StringBuilder allaSiffror = new StringBuilder();
 int count;

 while(siffra<500){
     count = 0;
     int temp = siffra;

     int num;
     while(temp>0){
       num=temp%10;  
       temp=temp/10;
       count += Math.pow(num,3);  
     }

     if (count == siffra){
       System.out.println(count);
       allaSiffror.append(count + " ");
     } 
     siffra++;
 }
System.out.println(allaSiffror.toString());


JOptionPane.showMessageDialog(null, allaSiffror.toString());