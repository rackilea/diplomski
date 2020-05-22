// You had better have a VERY good reason for making this static...
public void checker(String services[])
{
    for (String service : services) {
        JLabel label = labelLookup.get(service);
        if (label != null) {
            label.setText("Started");
        }
    }
}