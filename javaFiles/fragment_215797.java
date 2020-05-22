char[] letters  = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L'};

Scanner inp = new Scanner(System.in);
String input = (inp.nextLine());
char[] cord = input.toCharArray();

for (int x = 0; x < 10; x++)
    if (letters[x] == cord[1])
        System.out.println("Fk yeah!");