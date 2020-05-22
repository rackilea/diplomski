public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> nameOfPlayers = new ArrayList<String>();
        boolean isDuplicate = false;
        int i = 0;

        do {
            System.out.println("Enter player " + (i + 1) + ": or Q for Quit");
            String input = scanner.next();

            if (!input.equalsIgnoreCase("Q")) {
                if (nameOfPlayers.contains(input)) {
                    isDuplicate = true;
                } else {
                    nameOfPlayers.add(input);
                    isDuplicate = false;
                }
                System.out.println("CHECK : " + isDuplicate);
            } else {
                break;
            }

            i++;
        } while (!isDuplicate);
    }


Enter player 1: or Q for Quit
ankur
CHECK : false
Enter player 2: or Q for Quit
singhal
CHECK : false
Enter player 3: or Q for Quit
ankur
CHECK : true