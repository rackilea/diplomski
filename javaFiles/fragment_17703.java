boolean flag = false;
    while(rs.next()){
        boolean type=rs.getBoolean("Administrator");
        String dbUser=rs.getString("UserName");
        String dbPass=rs.getString("Password");

        if(un.equals(dbUser)&& pw.equals(dbPass)){

            if(type == true){
               AdMenu admenu=new AdMenu();
               admenu.show();
               this.setVisible(false);   

            } else{

               Menu menu=new Menu();
               menu.show();
               this.setVisible(false); 
            }  
              flag = true;
              break;     
        }
      }
      if(flag == true){
          JOptionPane.showMessageDialog(null,"Ïncorrect username or password"); 
}