btnBul.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        String arananad=textField_5.getText();
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         Connection baglanti = null;
         try {
             baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/iscikayit", "root", "");
         } catch (SQLException e) {
             e.printStackTrace();
         }
         String query="SELECT * FROM isci";
         Statement ifade = null;
         ResultSet rs = null
         try {

             ifade = baglanti.createStatement();
             rs = ifade.executeQuery(query) 

         } catch (SQLException e) {
             e.printStackTrace();
         } 


        while (rs.next())
        {

          int tcsi = rs.getInt("tc");
          String adi = rs.getString("ad");
          String soyadi=rs.getString("soyad");
          int telnosu=rs.getInt("telno");
          String epostasi=rs.getString("eposta");
          String egitimi=rs.getString("egitim");
          String adresi=rs.getString("adres");
          String cinsiyeti=rs.getString("cinsiyet");
          String askerliki=rs.getString("askerlik");
          String ehliyeti=rs.getString("ehliyet");
         textArea_1.setText("Tc:"+tcsi+"Adı:"+adi+"Soyadı:"+soyadi+"Telefon Numarası:"+telnosu+"E-posta adresi:"+epostasi+"Eğitim Düzeyi:"+egitimi+"Adresi:"+adresi+"Cinsiyet:"+cinsiyeti+"Askerlik:"+askerliki+"Ehliyet:"+ehliyeti); 
        }
        }});