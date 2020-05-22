try (FileChannel src = new FileInputStream("Lab5File1.dat").getChannel();
     FileChannel dest = new FileOutputStream("test.dat").getChannel()){
         dest.transferFrom(src, 0, src.size());
} catch (IOException e) {
    e.printStackTrace();
}