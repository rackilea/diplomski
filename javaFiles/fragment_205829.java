JPanel panel = [...];
ArrayList<String> cityNames = [...];
List<JLabel> cityLabels = new ArrayList<JLabel>();

for(String city : cityNames)
{
    JLabel label = new JLabel(city);
    cityLabels.add(label);
    panel.add(label);
}