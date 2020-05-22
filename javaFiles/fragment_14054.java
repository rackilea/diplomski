byte[] buffer = new byte[32];
    for (int i = 0; i < ciphertext.length; i++) {
        int num = cipher.update(ciphertext, i, 1, buffer);
        if (num > 0) {
            System.out.println("update #" + (i + 1) + " - data <" + new String(buffer, 0, num) + ">");
        }
    }
    int num = cipher.doFinal(ciphertext, ciphertext.length, 0, buffer);
    System.out.println("doFinal - data <" + new String(buffer, 0, num) + ">");