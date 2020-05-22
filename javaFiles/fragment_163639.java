//European countries use ";" as 
    //CSV separator because "," is their digit separator
    private static final String CSV_SEPARATOR = ",";
    private static void writeToCSV(ArrayList<Product> productList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("products.csv"), "UTF-8"));
            for (Product product : productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(product.getId() <=0 ? "" : product.getId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getName().trim().length() == 0? "" : product.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getCostPrice() < 0 ? "" : product.getCostPrice());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.isVatApplicable() ? "Yes" : "No");
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }