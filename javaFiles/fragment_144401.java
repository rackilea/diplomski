} finally {
    try {
        br.close();
        isr.close();
        is.close();
    } catch(IOException e) {
        e.printStackTrace();
    }
}