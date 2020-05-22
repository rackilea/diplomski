int[] array = new int[1000];
Scanner input = new Scanner(System.in);
int index = 0;
while(input.hasNext()) {
    array[index] = input.nextInt();
    index++;
}

HashMap<Integer, Boolean> seenNumbers = new HashMap<Integer, Boolean>();
String result = "";
for (int i = 0; i < index; i++) {
    int value = array[i];
    if (!seenNumbers.containsKey(value)) {
        result += " " + value;
        seenNumbers.put(value, true);
    }
}

System.out.println(result);