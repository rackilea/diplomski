try{
            while (!in.equalsIgnoreCase("y") && !in.equalsIgnoreCase("n")) {
                    System.out.print("\nDo you want to try again (Y/N)?");
                    in=input.readLine();
            }
        }catch(IOException e){
            System.out.println("Error!");
        }
    }while(in.equalsIgnoreCase("Y"));