List<ArrayList<String>> adj = new ArrayList<>();

int i = 0;

Scanner input = null;
try {
    input = new Scanner(new BufferedReader(new FileReader(fileName)));
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

String line;
while (input.hasNextLine()) {
    ArrayList<String> rows = new ArrayList<String>();
    i++;
    String[] cols = input.nextLine().trim().split(" ");
    for (String c : cols) {
        rows.add(c);
    }
    adj.add(rows);
}

for (ArrayList<String> list : adj) {
    for (String s : list) {
        System.out.print(s + " ");
    }
    System.out.println();
}