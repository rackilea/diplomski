List<Integer> par1 = new ArrayList();
List<String> par2 = new ArrayList();
List<Integer> par3 = new ArrayList();
List<String> par4 = new ArrayList();

try {
    for(String line : lines) {
        String[] elements = line.split(" ");
        if(elements.length == 4) {
            par1.add(Integer.valueOf(element[0])); 
            par2.add(element[1]));
            par3.add(Integer.valueOf(element[2]));
            par4.add(element[3]));
        }
        else {
            throw new Exception("Conversion failed");
        }
    }
}
catch(NumberFormatException ex) {
    throw new Exception("Conversion failed");
} 

// Convert ArrayList to Array if you need to.