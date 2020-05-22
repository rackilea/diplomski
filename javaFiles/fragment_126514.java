labelDisplay[1].setText(""+id);

 String labels[] = {guestInfo.getFirstName()+" "+guestInfo.getLastName(),
      ""+roomInfo.getRoomNo(),roomInfo.getRoomType(), guestInfo.getTime(),
      "11:00", ""+guestInfo.getDeposit(),"30"};

 labels = new String[7];

 for(int z = 0; z<labels.length; z++){
      labelDisplay[z].setText(labels[z]);
 }