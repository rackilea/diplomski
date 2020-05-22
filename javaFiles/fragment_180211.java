String input = "1,25,3-6,14,16-19";
String[] parts = input.split(",");
List<Integer> list = new ArrayList<>();

for (String part : parts) {
    if (part.contains("-")) {
        String[] range = part.split("-");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        for (int i=start; i <= end; ++i) {
            list.add(i);
        }
    }
    else {
        int value = Integer.parseInt(part);
        list.add(value);
    }
}