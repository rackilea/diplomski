import static java.lang.Character.digit;
...

private static byte[] stringToBytes(String input) {
    int length = input.length();
    byte[] output = new byte[length / 2];

    for (int i = 0; i < length; i += 2) {
        output[i / 2] = (byte) ((digit(input.charAt(i), 16) << 4) | digit(input.charAt(i+1), 16));
    }
    return output;
}

...

String keyExample = "99112277445566778899AABBCCDDEEFF0123456789ABCDEF0123456789ABCDEF";
byte[] key = stringToBytes(keyExample);    
byte[] barrayMessage = {123,45,55,23,64,21,65};    
byte[] result = decryptByte(barrayMessage, key);