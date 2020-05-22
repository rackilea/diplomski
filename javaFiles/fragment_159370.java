public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.print("How many players? ");
            int playerCount = scan.nextInt();
            scan.nextLine();

            HashMap<String, ArrayList<Die>> hashMap = new  HashMap<String, ArrayList<Die>>();
            int again = 1;

            for(int i = 0; i < playerCount; i++)
            {
                System.out.print("What is your name: ");
                hashMap.put(scan.nextLine(),new ArrayList<Die>());
            }

            for(String key : hashMap.keySet()){
                System.out.println(key + "'s turn....");
                Die d = new Die();
                System.out.println("Rolled : " + d.roll()) ;
                hashMap.get(key).add(d);
                System.out.println("Want More (Yes/No) ???");
                String choice = scan.next();
                while(choice != null && choice.equalsIgnoreCase("YES")){
                    if(hashMap.get(key).size()>4){System.out.println("Sorry, Maximum 5-Try you can...!!!");break;}
                    Die dd = new Die();
                    System.out.println("Rolled : " + dd.roll()) ;
                    hashMap.get(key).add(dd);
                    System.out.println("Want More (Yes/No) ???");
                    choice = scan.next();
                }
            }

            for(String key : hashMap.keySet()){
                System.out.println(key + " - " + hashMap.get(key));
            }


        }