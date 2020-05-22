private void add(){
    input1 = field1.getText();
    input2 = field2.getText();

    MathEquation problem = new MathEquation(input1, input2);

    Dimension lineSize = new Dimension(10, 10);

    JPanel line1 = new JPanel(); line1.setBackground(Color.WHITE); 
    JPanel line2 = new JPanel(); line2.setBackground(Color.WHITE); 
    JPanel line3 = new JPanel(); line3.setBackground(Color.WHITE); 
    JPanel line4 = new JPanel(); line4.setBackground(Color.WHITE); 
    JPanel line5 = new JPanel(); line4.setBackground(Color.WHITE); 

    JLabel[] sumLabels = problem.getSumLabels();
    JLabel[] addend1Labels = problem.getAddend1Labels();
    JLabel[] addend2Labels = problem.getAddend2Labels();
    JLabel[] carriedLabels = problem.getCarriedLabels();

    for(int i = 0; i < carriedLabels.length; i++){
        line1.add(carriedLabels[i]);
    }

    for(int i = 0; i < addend1Labels.length; i++){
        line2.add(addend1Labels[i]);
    }

    for(int i = 0; i < addend2Labels.length; i++){
        line3.add(addend2Labels[i]);
    }

    String answerLine = "__";

    for(int i = 0; i < sumLabels.length; i++){
        answerLine += "__";
    }

    line4.add(new JLabel(answerLine));

    for(int i = 0; i < sumLabels.length; i++){
        line5.add(sumLabels[i]);
    }

    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));
    answerPanel.add(line1);
    answerPanel.add(line1);
    answerPanel.add(line2);
    answerPanel.add(line3);
    answerPanel.add(line4);
    answerPanel.add(line5);
    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));
    answerPanel.add(new JLabel(" "));

    this.setContentPane(answerPanel);
    this.revalidate();//

    }