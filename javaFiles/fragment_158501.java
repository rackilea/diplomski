click.addActionListener (new ActionListener (){
        public void actionPerformed (ActionEvent x) {
            //Get random filepath from the array
            Random rand = new Random();
            int random = rand.nextInt(word.length);
            String temp = word[random];

            InputStream in =null;
            AudioStream out = null;
            //Get the actual file from the path
            try {
                in = new FileInputStream(temp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                out = new AudioStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }       
            //Play the file
            AudioPlayer.player.start(out);
            return;
        }
    });