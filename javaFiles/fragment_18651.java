FileInputStream fis = new FileInputStream("awesomefile.csv"); 
InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
CSVReader reader = new CSVReader(isr);

for (String[] row; (row = reader.readNext()) != null;) {
    System.out.println(Arrays.toString(row));
}

reader.close();
isr.close();
fis.close();