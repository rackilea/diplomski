Scanner scanner = new Scanner(filePath);
Object syncObject = tClientCache.getSynchronizationObject();
ArrayList<Integer> list = tClientCache.getCache();

while(scanner.hasNext()) {
    if(scanner.hasNextInt()) {
        int temp = scanner.nextInt();
        // synchronise manipulation
        synchronized(syncObject) {
            list.add(temp);
        }
    } else {
        scanner.next();
    }
}

scanner.close();