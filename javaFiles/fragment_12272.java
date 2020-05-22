try (FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                fos))) {
    for (int i = start; i <= stop; i++) {
        String line = "Importeduser" + i + ",Test,4," + r.nextInt(9)
                + r.nextInt(9) + r.nextInt(9) + r.nextInt(9)
                + r.nextInt(9) + r.nextInt(9) + ",0," + r.nextInt(9)
                + r.nextInt(9) + r.nextInt(9) + r.nextInt(9)
                + r.nextInt(9) + r.nextInt(9) + r.nextInt(9)
                + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);
        System.out.println(line);
        bw.write(line);
        bw.newLine();
    }
}