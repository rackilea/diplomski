String tmp = "A|B|C|D|E|F|";
int count = 0;
int[] start = new int[5];
for (int i = 0; i < tmp.length(); i++)
    if (tmp.charAt(i) == '|' && count < start.length)
        start[count++] = i;
System.out.println(start[0] + "|" +start[1] + "|" +start[2] + "|" +start[3] + "|" +start[4]);