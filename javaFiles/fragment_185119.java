String str = "qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT";
char[] arr = str.toCharArray();
int count = 1;
StringBuilder sb = new StringBuilder();
char prev = arr[0];

for (int i = 1; i < arr.length; i++) {
    char curr = arr[i];
    prev = arr[i - 1];
    if (curr == prev) {
        count++;
    } else {
        if (count < 2) {
            sb.append(prev);
        } else {
            sb.append(count).append(prev);
            count = 1;
        }
    }
}

if (count < 2) {
    sb.append(prev);
} else {
    sb.append(count).append(prev);
}

System.out.println("Compressed : " + sb.toString());