public static void main(String[] args) {
       System.out.println("Taxable Income\t\t Single\t\t Married Joint\t\t MarriedSeerate\t\t HeadofaHouse");
       System.out.println("-----------------------------------------------------------------------------------------------------");
       double Tincome;
       int profile=1;
       for(Tincome=50000; Tincome<=60000; Tincome+=50) { 
           double single=computetax(1, Tincome);
           double joint=computetax(2, Tincome);
           double seperate=computetax(3, Tincome);
           double head=computetax(4, Tincome);
           System.out.println( Tincome +"\t\tsingle:\t" + single + "\tjoint:\t" + joint + "\tseparate:\t" + separate + "\thead:\t" + head);
       }
    }

    public  static double computetax( int status , double income) {
        double tax;
        double single=0;
        double mjoint=0;
        double mseperate=0;
        double head=0;

            if(status==1) {  
                tax = 8350*.10 + (33950-8350)*0.15 + (income- 33950)*0.25;
                single= tax;
            }
            if(status==2) {
                tax = 16700*0.10 + (income-16700)*0.15;
                mjoint = tax;
            }   
            if(status==3 ) {
                tax =  8350*0.10 + (33950-8350)*0.15 + (income-33950)*0.25;
                mseperate= tax;
            }
            if(status ==4){
                tax = 11950*0.10 + (45500-11950)*0.15 +(income-45500)* 0.25;
                head =tax;
            }    
        }
    return (single);
    }
}