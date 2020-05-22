public static void main(String[] args) {

            Scanner kb=new Scanner(System.in);
            System.out.println("Enter Limit");
            double limit=kb.nextDouble();

            int TermsSum=1;
            double min=1;
            double PiVal= 4.0 / min;
            double PiCon = 4.0 / min;
            System.out.print("4.0 /" + min);
            while (limit<=PiCon) {
                if (limit <= PiCon) {
                    TermsSum++;
                    min += 2;
                    PiCon = (4.0 / min);
                    PiVal += (-(PiCon));
                    System.out.print("-"+"4.0 /" + min);
                }
                if (limit <= PiCon) {
                    TermsSum++;
                    min += 2;
                    PiCon = (4.0 / min);
                    PiVal += (PiCon);
                    System.out.print("+"+"4.0 /" + min);
                }


            }
            System.out.println("Limit: "+limit);
            System.out.println("Pi Value: "+PiVal);
            System.out.println("Terms Summed: "+TermsSum);
        }