FileWriter fstream = new FileWriter(file);
BufferedWriter out = new BufferedWriter(fstream);
while (rs.next()) {            
        out.write(Integer.toString(rs.getInt("SBL_PRODUCT_ID")) + ", ");
        out.write(Integer.toString(rs.getInt("SBL_TARIFF_ID")) + ", ");
        out.write(rs.getString("PRODUCT_DESCRIPTION") + ", ");
        out.write(rs.getString("SERVICE_TYPE") + ", ");
        out.write(Integer.toString(rs.getInt("MARKET_CLASS")) + ", ");
        out.write(rs.getString("ENTITY_TYPE") + ", ");
        out.newLine();
        /*out.write(System.getProperty("line.separator"));*/
}
System.out.println("Completed writing into text file");
out.close();