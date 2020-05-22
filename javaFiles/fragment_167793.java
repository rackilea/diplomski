String [] product_list = new String [100];
int counter = 0;

Scanner scanner = new Scanner(System.in);
System.out.println("Input as follows:");
System.out.println("Home team : Away team : Home score : Away score");

String line = null;

while (!(line = scanner.nextLine()).equals("")) {

    if (line.equals("quit")) {
           break;
    } else {
        product_list[counter] = line;

        System.out.println("Home team : Away team : Home score : Away score");
    }

    counter++;  
}

for (int i = 0; i < counter; i++) {
    String[] words = product_list[i].split(":");
    System.out.println(words[0].trim() + " : " + words[2].trim() + " | " + words[1].trim() + " : " + words[3].trim());
}