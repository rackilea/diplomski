private double calcGradeValue (int pos) {
         if (pos == 0){
             //A+
             gradeValue = 4.0;
         } else if (pos == 1){
             //A
             gradeValue = 4.0;
         } else if (pos == 2){
             //A-
             gradeValue = 3.7;
         } else if (pos == 3){
             //B+
             gradeValue = 3.3;
         } else if (pos == 4){
             //B
             gradeValue = 3.0;
         } else if (pos == 5){
             //B-
             gradeValue = 2.7;
         } else if (pos == 6){
             //C+
             gradeValue = 2.3;
         } else if (pos == 7){
             //C
             gradeValue = 2.0;
         } else if (pos == 8){
             //C-
             gradeValue = 1.7;
         } else if (pos == 9){
             //D+
             gradeValue = 1.3;
         } else if (pos == 10){
             //D
             gradeValue = 1.0;
         } else if (pos == 11){
             //D-
             gradeValue = 0.7;
         } else if (pos == 12){
             //F
             gradeValue = 0.0;
         }
        return gradeValue;
    }

    public void spinnerLoop() {
        for(int i = 0; i < allSp.size(); i++) {
            if (allSp.get(i).getTag().toString() == "TAGGED!") {
                double gradeValue = calcGradeValue(allSp.get(i).getSelectedItemPosition()); 
                double calculation = (gradeValue) * (Integer.parseInt(allEd.get(i).getText().toString()));
//              do something with your calculation double
            }
        }
    }