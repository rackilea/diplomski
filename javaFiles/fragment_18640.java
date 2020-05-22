private void btnTotalMouseClicked(java.awt.event.MouseEvent evt) {                                      
        String userTotal = "";
        String userBonus = "";

        int bonus = 1000;
        for(int i=0; i < rowNumber; i++){
            int total = (points[i][0] + points[i][1] + points[i][2] + points[i][3]);
            userTotal += name[i][0] + "'s Total Points are: " + total + "\n";
            userBonus += name[i][0] + "'s Total Points are: " + total + " Bonus: " + bonus + "\n";
                if(total > 5000){
                    outPut.setText(userBonus);                        
                }else{
                    outPut.setText(userTotal);
                }
        }
    }                                     

}