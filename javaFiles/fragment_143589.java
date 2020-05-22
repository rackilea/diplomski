while (scanFile.hasNextLine()) {
     Scanner scanPhone = new Scanner(scanFile.nextLine());
     scanPhone.useDelimiter(", *");

     String phoneType = scanPhone.next();
     char phoneChar = phoneType.toUpperCase().charAt(0);

     //Assigns phone to different category
     switch (phoneChar) {   
        case 'F':
           String number = scanPhone.next();
           int texts = Integer.parseInt(scanePhone.next());
           int minutes = Integer.parseInt(scanPhone.next());
           FlipPhone flip1 = new FlipPhone(number, texts, minutes);
           addPhone(flip1);
           break;