while (scanner.hasNext()){
            int num = 0;
            try{
                num = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException ne){

            }
            sum += num;
        }