StringBuilder sb = new StringBuilder();
sb.append("select count(*) from Product p where ");
if (productNameCriteria.equalsIgnoreCase("IS"))
    sb.append("p.productName = '").append(productName).append("'");
// etc
String query = sb.toString();