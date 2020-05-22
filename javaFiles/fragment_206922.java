while(true) {
        character = (char) reader.read();
        if(Character.isISOControl(character)) {
            System.out.println();
        }
        else {
            System.out.printf("%c", character);
        }           
    }