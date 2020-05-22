JRadioButton rock = new JRadioButton("Rock");
JRadioButton paper = new JRadioButton("Paper");
JRadioButton scissors = new JRadioButton("Scissors");

ButtonGroup bg = new ButtonGroup();
bg.add(rock);
bg.add(paper);
bg.add(scissors);

JPanel rockPanel = new JPanel();                         <-- Rock panel
rockPanel.add(rock);                                     <-- Rock RB
rockPanel.add(new JLabel(new ImageIcon("rock.png"));     <-- Rock Icon

JPanel paperPanel = new JPanel();                        <-- Paper Panel
rockPanel.add(paper);                                    <-- Paper RB
rockPanel.add(new JLabel(new ImageIcon("paper.png"));    <-- Paper Icon

JPanel scissorsPanel = new JPanel();                     <-- Scissors Panel
rockPanel.add(scissors);                                 <-- Scissors RB
rockPanel.add(new JLabel(new ImageIcon("scissors.png")); <-- Scissors Icon

JPanel holdThreePanel = new JPanel(new GridLayout(3, 1));
holdThreePanel.add(rockPanel);                           <-- Rock Panel
holdThreePanel.add(paperPanel);                          <-- Paper Panel
holdThreePanel.add(scissorsPanel);                       <-- Scissors Panel