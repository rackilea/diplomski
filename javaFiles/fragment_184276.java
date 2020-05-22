n++;

String line;
do {
    if (!sc.hasNext()) { return result; }
    line = sc.nextLine();
} while (!meetsConstraints(line));

if (rand.nextInt(n) == 0) {
    result = line; 
}