FileWriter fw = new FileWriter("randomdata.txt");
for (int i = 0; i < 1000; i++){
    num = gen.nextInt(500);
    fw.write(num + "\n");
}
fw.close();