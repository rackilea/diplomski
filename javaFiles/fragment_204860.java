public class BloodList extends JComboBox <String> {
    private String s="";

    private String[] bloodList =
            {
                    "1",
                    "2",
                    "3",

            };

    public BloodList() {
        for (int i=0; i < bloodList.length; i++)
        {
            this.addItem(bloodList[i]);
        };
    }

    ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                s = (String) BloodList.this.getSelectedItem();//get the selected string
            }
    };

    this.addActionListener(cbActionListener);

    public String getS(){return s;}

}