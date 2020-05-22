try(FileWriter fw = new FileWriter("licensePlate2.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw)) {
    for (String letters : app.letterList) {
        for (String numbers : app.numberList) {
            out.print(letters);
            out.println(numbers);
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}