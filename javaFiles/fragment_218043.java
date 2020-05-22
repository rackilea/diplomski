public void prepareImages() {
    for (int i = 0; i < 5; i++) {
        JWA[i] = new JWindow();
        System.out.println("/testingPackage/" + "R" + (i + 2) + ".jpg");
        s0.labelNow("/testingPackage/" + "R" + (i + 2) + ".jpg");
        JWA[i].getContentPane().add(s0.labelNow("/testingPackage/" + "R" + (i + 2) + ".jpg"));
        JWA[i].pack();
        JWA[i].setLocation(10 + i * 20, 350);
        JWA[i].setVisible(true);
    }
}