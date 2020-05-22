static int countFiles(File f) {
    if (f.isDirectory()) {
        int sum = 0;
        for (File fi : f.listFiles()) 
            sum += countFiles(fi);
        return sum;
    }
    return 1;
}