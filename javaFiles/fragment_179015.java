OutputStream out = proc.getOutputStream();
    new Thread(() -> {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            bw.write("[command here]");
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }).start();