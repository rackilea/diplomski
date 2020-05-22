String input = "hello bro how are you";
String[] parts = input.split(" ");
StringBuilder sb = new StringBuilder();

for (int i=0; i < parts.length; ++i) {
    StringBuilder rev = new StringBuilder(parts[parts.length - i - 1]);
    if (i > 0) sb.append(" ");
    sb.append(i % 2 == 0 ? rev.reverse() : rev);
}

System.out.println(sb.toString());

uoy are woh bro olleh