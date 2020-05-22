int [] scans = new int[4];
System.out.println("Enter 4 numbers into the array: " );
Scanner scanner = new Scanner(System.in);
for (int i=0; i<scans.length; i++) {
    scans [i] = scanner.nextInt();
}

String prefix = "";
String result = "";
for(int i=0; i<scans.length; i++){
    result = result + prefix + scans[i];
    prefix = "|";
}

System.out.println(result);