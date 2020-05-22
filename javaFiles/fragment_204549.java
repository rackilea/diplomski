StringBuilder sb = new StringBuilder();

sb.append("<html>");
sb.append("<b>Your companies and stocks are</b>");
sb.append("<table>");
for (int i = 0; i < stocks.length; i++) {
    sb.append("<tr><td>"+stocks[i].getName()+"</td><td>"+String.valueOf(stocks[i].getPrice())+"</td><td>"+String.valueOf(stocks[i].calCostMA())+"</td></tr>");
}       
sb.append("</table>");
sb.append("</html>");

sb.append("The total amount is: "+String.valueOf(BestStocksMA.getTotalCostMA()));

JOptionPane.showMessageDialog(null, sb.toString());