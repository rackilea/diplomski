String input = "We have 55 guests in room 38";
int sum = 0;

String[] split = input.split(" ");       // split based on space
for (int i = 0; i < split.length; i++) {
    if (split[i].matches("[0-9]+")) {
        sum = sum + Integer.parseInt(new StringBuffer(split[i]).reverse().toString());
    }
}

System.out.println(sum);