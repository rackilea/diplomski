setSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
this.getContentPane().setLayout(null);
this.getContentPane().setBackground(backColor);
talkArea.setEditable(false);
talkArea.setBackground(Color.white);
talkArea.setBounds(new Rectangle(TALK_LEFT, TALK_TOP, TALK_WIDTH,      TALK_HEIGHT));
this.getContentPane().add(talkArea, null); // <--- you want this inside the text area, not here!
// set input area
inputField.setBackground(Color.white);
inputField.setBounds(new Rectangle(INPUT_LEFT, INPUT_TOP, INPUT_WIDTH,      INPUT_HEIGHT));
inputField.addActionListener(this);
this.getContentPane().add(inputField, null);
this.getContentPane().add(talkAreaScrollPane, null);  // <--- you never set the size on here