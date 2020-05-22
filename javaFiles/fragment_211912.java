String s = "A very long string containing " +
    "many many words and characters. " +
    "Newlines will be entered at spaces.";

StringBuilder sb = new StringBuilder(s);

int i = 0;
while ((i = sb.indexOf(" ", i + 30)) != -1) {
    sb.replace(i, i + 1, "\n");
}

System.out.println(sb.toString());