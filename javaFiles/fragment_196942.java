val5.addActionListener((e) -> {    // this is the lambda-approach to write the ActionListener implementation (since the interface has only one method, you can just write your method here)
     if(sum<1000){      // here you can access the sum variable directly
         sum+=5;        // update its value
         counter.setText(".....");  // set the new label text
     }
});