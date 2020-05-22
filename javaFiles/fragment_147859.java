public static void main(String[] args) {
  Dumper device = new Dumper();
  MultiThreaded master = new MultiThreaded(device);
  master.start();
  device.start();
}