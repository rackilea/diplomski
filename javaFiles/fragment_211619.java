final int MAX_NUM_GRADES = 4;
  double avg;
  double sum = 0;
  double min = Double.MAX_VALUE;
  int count = 1;
  double[] examGrade = new double[MAX_NUM_GRADES];
  for (int i = 0; i < examGrade.length; i++) {
     boolean invalid = true;
     while(invalid) {
     try {
        examGrade[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter Grade " + count + ":"));
        if (examGrade[i] < 0 || examGrade[i] > 100) {
           JOptionPane.showMessageDialog(null,"ERROR!.");           
        }
        else {
           invalid = false;
           count++;
           sum = sum + examGrade[i];
           if(examGrade[i] < min) min = examGrade[i]; 
        }
     }
     catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null,"ERROR!");         
     }
     }      
  }
  avg = (sum - min)/(examGrade.length - 1);
  JOptionPane.showMessageDialog(null,"average exam grade is: " 
     + String.format("%.1f",avg));