Scanner scanner = new Scanner(filePath);
int threshold = ...

while(scanner.hasNext()) {
    if(scanner.hasNextInt()) {
        int temp = scanner.nextInt();
        bulk.add(temp);
        // instead of an arbitrary threshold, why not merge the array of a whole file?
        if(bulk.size() >= threshold) {
            tClientCache.process(bulk);
            bulk.clear();
        }
    } else {
        scanner.next();
    }
}
if(!bulk.isEmpty()) {
    tClientCache.process(bulk);
}

scanner.close();