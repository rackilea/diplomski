try {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        for (int numero : array) {
            out.write(Integer.toString(numero) + "\n");
    }
    out.flush();
    out.close();