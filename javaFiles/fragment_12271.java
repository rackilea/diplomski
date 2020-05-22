try {
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
} finally {
    if (bw != null) {
        bw.close();
    }
    if (fos != null) {
        fos.close();
    }
}