BufferedWriter writer = new BufferedWriter(new FileWriter("result.dat"));

for(EmpHeaderDetails ehd : ehdList) {
  writer.write(ehd.toString());
}

writer.close();