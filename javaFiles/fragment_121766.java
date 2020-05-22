public static void main(String args[]) {

          Scanner scan = new Scanner(System.in);
          String s1 = scan.nextLine();
          String s2 = scan.nextLine();
          String s3 = scan.nextLine();
          if (s1.compareTo(s2) < 0 & s1.compareTo(s3) < 0 & s2.compareTo(s1) > 0 & s2.compareTo(s3) < 0 & s3.compareTo(s1) > 0 & s3.compareTo(s2) > 0) 
          {
            System.out.println("Ordnung:" + s1 +" "+ s2 +" " + s3);  
          }
          else if (s1.compareTo(s2) < 0 & s1.compareTo(s3) < 0 & s2.compareTo(s1) > 0 & s2.compareTo(s3) > 0 & s3.compareTo(s1) > 0 & s3.compareTo(s2) < 0) 
          {
            System.out.println("Ordnung:" + s1 +" "+ s3 +" " + s2);  
          }
          else if (s1.compareTo(s2) > 0 & s1.compareTo(s3) < 0 & s2.compareTo(s3) < 0 & s2.compareTo(s1) < 0 & s3.compareTo(s1) > 0 & s3.compareTo(s2) > 0) 
          {
            System.out.println("Ordnung:" + s2 +" "+ s1 +" " + s3);  
          }
          else if (s1.compareTo(s2) > 0 & s1.compareTo(s3) > 0 & s2.compareTo(s1) < 0 & s2.compareTo(s3) < 0 & s3.compareTo(s1) < 0 & s3.compareTo(s2) > 0) 
          {
            System.out.println("Ordnung:" + s2 +" "+ s3 +" " + s1);  
          }
          else if (s1.compareTo(s2) < 0 & s1.compareTo(s3) > 0 & s2.compareTo(s3) > 0 & s2.compareTo(s1) > 0 & s3.compareTo(s1) < 0 & s3.compareTo(s2) < 0)
          {
            System.out.println("Ordnung:" + s3 +" "+ s1 +" " + s2);  
          }
          else if (s1.compareTo(s2) > 0 & s1.compareTo(s3) > 0 & s2.compareTo(s1) < 0 & s2.compareTo(s3) > 0 & s3.compareTo(s2) < 0 & s3.compareTo(s1) < 0)
          {
            System.out.println("Ordnung:" + s3 +" "+ s2 +" " + s1);  
          } else{
              System.out.println("Ungueltige Eingabe");
          }
    }
 }