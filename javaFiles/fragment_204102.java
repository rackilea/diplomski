for (int j = 0; j < array.length - 1; j++) {
    for (int x = 0; x < array.length - 1; x++) {
        if (array[x] > array[x + 1]) {
            int temp = array[x];
            array[x] = array[x + 1];
            array[x + 1] = temp;
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(newClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}