File comms = new File("src/Resources/com.txt");
    try(Scanner scan = new Scanner(comms)) {
        while(scan.hasNext()) {
            String line = scan.nextLine();

            String[] words = line.split(" ");

            System.out.println(words[0]); // "Hi"
            System.out.println(words[1]); // "0x01"
        }
    }
    catch(Exception e) {

    }