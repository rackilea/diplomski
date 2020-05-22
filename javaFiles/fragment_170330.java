temp = JOptionPane.showInputDialog(null, "What temperature is it outside?");
temperature = Integer.parseInt(temp);
temp = JOptionPane.showInputDialog(null, "What percentage of humidity is there?");
humidity = Double.parseDouble(temp);
temp = "";
while (!temp.equals("yes") && !temp.equals("no")) {
   temp = JOptionPane.showInputDialog(null, "Is it cloudy out? Type 'yes' or 'no' ");
}
if (temp.equals("yes"))
  sunshine = 25;
else
  sunshine = -25;

rating = temperature + humidity + sunshine;