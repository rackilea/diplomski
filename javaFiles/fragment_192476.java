else
    {
       System.out.println(jTextArea5.getText( ));
        String binary = jTextArea5.getText();
        StringTokenizer st = new StringTokenizer(binary," ");
         while(st.hasMoreTokens()){
             int ascii = Integer.parseInt(st.nextToken(), 2);
             char character = (char)ascii;
             jTextArea1.setText(jTextArea1.getText() + "" + character); 

         }
    }