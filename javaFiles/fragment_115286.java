String str = "KITTEN";
byte[] bytes = str.getBytes();
for(byte b : bytes) {
    System.out.print("'" + (char) b + "' ");
}

'K' 'I' 'T' 'T' 'E' 'N'