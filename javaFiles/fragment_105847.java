//Folder --------------------------------------------------------
folderPanel.setBackground(Color.WHITE);
folderPanel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridheight = 1;
gbc.gridwidth = 1;
gbc.weightx = 1;
gbc.weighty = 0;    /////////////////////////////   added
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.anchor = GridBagConstraints.NORTHWEST;

JLabel iCell = new JLabel();
JLabel nameCell = new JLabel();
JLabel typeCell = new JLabel();
JLabel dateCell = new JLabel();
iCell.setPreferredSize(new Dimension(50, 60));
iCell.setHorizontalAlignment(SwingConstants.CENTER);
nameCell.setPreferredSize(new Dimension(50, 60));
nameCell.setHorizontalAlignment(SwingConstants.CENTER);
typeCell.setPreferredSize(new Dimension(50, 60));
typeCell.setHorizontalAlignment(SwingConstants.CENTER);
dateCell.setPreferredSize(new Dimension(50, 60));
dateCell.setHorizontalAlignment(SwingConstants.CENTER);
int gridy = 0;
int i = 0;

iCell.setText("#");
gbc.gridx = 0;
gbc.gridy = gridy;
folderPanel.add(iCell, gbc);
//---------------------------------------------
nameCell.setText("Name");
gbc.gridx = 1;
gbc.gridy = gridy;
folderPanel.add(nameCell, gbc);
//---------------------------------------------
typeCell.setText("Type");
gbc.gridx = 2;      
gbc.gridy = gridy;
folderPanel.add(typeCell, gbc);     
//---------------------------------------------
dateCell.setText("Date");
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.gridx = 3;  
gbc.gridy = gridy;
folderPanel.add(dateCell, gbc);

gbc.weighty = 1;        ////////////////////////   added
gridy++;
i++;

DBCursor cursor = imagesCollection.find();
try {
    while(cursor.hasNext()) {
        DBObject obj = cursor.next();

        iCell = new JLabel();
        nameCell = new JLabel();
        typeCell = new JLabel();
        dateCell = new JLabel();
        iCell.setPreferredSize(new Dimension(50, 60));
        nameCell.setPreferredSize(new Dimension(50, 60));
        typeCell.setPreferredSize(new Dimension(50, 60));
        dateCell.setPreferredSize(new Dimension(50, 60));

        iCell.setText(Integer.toString(i));
        gbc.gridx = 0;
        gbc.gridy = gridy;
        folderPanel.add(iCell, gbc);
        //---------------------------------------------
        nameCell.setText((String) obj.get("name"));
        gbc.gridx = 1;
        gbc.gridy = gridy;
        folderPanel.add(nameCell, gbc);
        //---------------------------------------------
        typeCell.setText((String) obj.get("type"));
        gbc.gridx = 2;      
        gbc.gridy = gridy;
        folderPanel.add(typeCell, gbc);     
        //---------------------------------------------
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateCell.setText(df.format(obj.get("creationDate")));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;  
        gbc.gridy = gridy;
        folderPanel.add(dateCell, gbc);

        gridy++;
        i++;
    }

} finally {
   cursor.close();
}
JScrollPane scroller = new JScrollPane(folderPanel);