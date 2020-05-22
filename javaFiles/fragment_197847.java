public void saveProductsToDisk() {

    String filename = 

"/Users/paddy/UCSC/Workspace/productDB/src/productdb/savedProducts.csv";
    BufferedWriter output = null;
    try 
    {
        output =  new BufferedWriter(new FileWriter(filename));
        StringBuilder line = null;
        for (Product p: getAllProducts())
        {
            line = new StringBuilder();
            line.append(p.getId() <=0 ? "" : p.getId());
            line.append(CSV_SEPARATOR);
            line.append(p.getName().trim().length() == 0? "" : p.getName());
            line.append(CSV_SEPARATOR);
            line.append(p.getPrice() < 0 ? "" : p.getPrice());
            line.append(CSV_SEPARATOR);
            line.append(p.getDept().toString());
            line.append("\n");
            output.write(line.toString());
        }
        output.flush();
        output.close();
    }
    catch (IOException ex)
    {
        System.out.println("IO error for " + filename +
                ": " + ex.getMessage());
    }
}