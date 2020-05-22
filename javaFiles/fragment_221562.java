public void run(){
    LocalObject a= new LocalObject(); //this is a new instance 
    method2(a);
}


public static void main(String args[]){
    LocalObject a= new LocalObject(); //this is an antirelz different instance
    a.start(); 
    a.method2(a);
}