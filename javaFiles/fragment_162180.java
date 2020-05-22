Scanner scanner = new Scanner(filePath);

while(scanner.hasNext()) {
    if(scanner.hasNextInt()) {
        int temp = scanner.nextInt();
        tClientCache.getCache().add(temp);
    } else {
        scanner.next();
    }
}

scanner.close();