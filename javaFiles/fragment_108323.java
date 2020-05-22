package Reloj;

import java.util.Scanner;

/**
 *
 * @author MarcoAntonio
 */
public class Temporizador {

     //Metodo estatico de mi aplicacion de AppLibreria
    public static void limpiaPantalla(){
        //Limpiando la pantalla
            for(int i = 0; i<25 ; i++){
                System.out.println();
            }    }

    private int hr;
   private int min;
   private int seg;


   public Temporizador (){

       hr  = min = seg = 0;

   }

   public Temporizador(int h, int m, int s){

       this();
       hr  = h;
       min = m;
       seg = s;

   }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getSeg() {
        return seg;
    } 

   public void decrementa(){
       if(hr == 0){
           if(min == 0 && seg != 0){
                  seg--;  
           }
           if(min != 0 && seg == 0){
               min--;
               seg = 59;
           }
           if(min != 0  && seg != 0){
               seg--;
           }
       }
       if(hr != 0){
           if(min == 0 && seg == 0){
               hr--;
               min = 59;
               seg = 59;
           }
           if(min == 0 && seg != 0){
                  seg--;  
           }
           if(min != 0 && seg == 0){
               min--;
               seg = 59;
           }
           if(min != 0  && seg != 0){
               seg--;
           }

       }
   }

   @ Override
   public String toString(){
       String tiempo = "";
       String ap;
       if(hr < 10){
           tiempo += "0" + hr + ":";         
       }
       else{
           tiempo += hr + ":";
       }
       if(min < 10){
           tiempo +="0" + min + ":";  
       }
       else{
           tiempo += min + ":";
       }
       if(seg < 10){
           tiempo +="0" + seg + " ";  
       }
       else{
           tiempo += seg + " ";
       }

       return tiempo;
   }

   public static void main(String args[]){

       boolean m = true;

       Temporizador t  = new Temporizador();
       Scanner       s = new Scanner(System.in);

       System.out.println("Buenas tardes...");
       System.out.println("Bienvenido al temporizador, a continuacion selecione las horas, minutos y segundo");
       System.out.println("para empezar la cuenta regresiva. P:");

           do{
       System.out.println("¿Cuantas horas?");
       int horas = Integer.parseInt(s.nextLine());
       t.setHr(horas);

       System.out.println("¿Cuantos minutos?");
       int minutos = Integer.parseInt(s.nextLine());
       t.setMin(minutos);

       System.out.println("¿Cuantos segundos?");
       int segundos = Integer.parseInt(s.nextLine());
       t.setSeg(segundos);

       if( t.getHr() == 0 && t.getMin()== 0 && t.getSeg()==0 ){
          System.out.println("No inicializado su temporizador");

       limpiaPantalla();}

       }while(t.getHr() == 0 && t.getMin()== 0 && t.getSeg()==0);

         do{ 

             System.out.println(t.toString());
           t.decrementa();
           try{
               Thread.sleep(1);// un thread es una ejecucion en el procesador
           }catch(Exception e){}
           if(t.getHr() == 0 && t.getMin()== 0 && t.getSeg()==0){
               m = false;
           }
       }while( m != false);

      System.out.println("Listones! Tiempo finalizado");


   }
}