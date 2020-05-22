do{
        for(int search = 0; search < PinSearch.length; search++){
            String SearchForPin = PinSearch[search];
            if(SearchForPin.matches(PinToWrite)){
                pinTrue = true;
                System.out.println("Success!");
            }
            else if(search => PinSearch.length){
                System.out.println("Error! Invalid pin.");
            }
        }
        LineFromFile = bufferedReader.readLine();
        if (LineFromFile != null) {
            PinSearch = LineFromFile.split("\\s+");
            UserPin = java.util.Arrays.toString(EnterPin);
            PinMod = UserPin.replaceAll("\\[", "");
            PinMod2 = PinMod.replaceAll("\\,", "");
            PinMod3 = PinMod2.replaceAll("\\s+", "");
            PinToWrite = PinMod3.replaceAll("\\]", "");
        }
    } while(pinTrue == false && LineFromFile != null);