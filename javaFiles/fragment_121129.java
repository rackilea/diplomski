public static class SplitSnakeCreationPane extends JPanel {
        //Count of how many snakes created
        private static int snakeCount = 1;

        private JTextField snakeName = null;
        private JTextField channelCount = null;        
        private JCheckBox artistSupplied = null;

        public SplitSnakeCreationPane() {

            //creates Snake Panes
            setLayout(new GridLayout(2, 4, 10, 10));
            add(new JLabel("Split Snake " + (snakeCount++) + "."));
            add(new JLabel("Snake Name"));
            add(new JLabel("Channel Count"));
            add(new JLabel(""));
            add(new JLabel(""));
            snakeName =  new JTextField(30);
            channelCount = new JTextField("0",3);
            artistSupplied = new JCheckBox("Artist Supplied?");
            add(snakeName); //Snake Name field
            add(channelCount);  //Channel Count field
            add(artistSupplied); //Artist supplied checkbox
            setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        }

        public String getSnakeName() {
            return snakeName.getText();
        }

        public String getChannelCount() {
            return channelCount.getText();
        }

        public boolean getArtistSupplied() {
            return artistSupplied.isSelected();
        }
    }