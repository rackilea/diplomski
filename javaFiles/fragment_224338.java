String hello = "aaaa";
Pattern pattern = Pattern.compile("aa");
Matcher matcher = pattern.matcher(hello);

int count = 0;
int i = 0;
while (matcher.find(i)) {
    count++;
    i = matcher.start() + 1;
}

System.out.println(count);    // prints 3