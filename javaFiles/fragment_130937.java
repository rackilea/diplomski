try {
    int val = Integer.parseInt(formatter8.print(period8));
    tw.setText(String.format("%02d",val));
} catch (NumberFormatException nfe) {
    nfe.printStackTrace();
}