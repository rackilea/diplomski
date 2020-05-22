int allowedAttempts=0;
while(true) 
{
   try{    
       rad = br.readLine(); 
       r = Integer.parseInt(rad); 
       System.out.println("Circle area is: " + PI*r*r + " Permieter: " +PI*2*r); 
       break;
       }
       catch(Exception e){
            System.out.println("Write an integer number"); 
            allowedAttempts++;
            if(allowedAttempts==3){
                    System.out.println("No More attempts allowed");break;
                }
        }
}