try {
   FileWriter fw = new FileWriter("src/winners.txt", true);
   fw.write(band[winningBand].getInfo);
   fw.close();
} catch (Exception e) {
   e.printStackTrace();
}