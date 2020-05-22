byte[][] A = new byte[][] {
            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1 },
            { 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 } };
String result = "";
int counter = 0;
for (byte[] arr : A) {
    for (byte b : arr) {
        if (b == 1)
            counter++;
        else {
            if (counter > 0)
                result += counter;
            counter = 0;
        }
    }
}
if (counter > 0)
    result += counter;
System.out.println(result);