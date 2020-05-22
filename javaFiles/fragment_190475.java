try (Connection connection = ConnectionHelper.getConnection();
     PreparedStatenent ps = 
            conn.prepareStatement("select image from file where nama = ?")) {

       ps.setXXX() // set the value for 'nama'
       ResultSet rs = ps.executeQuery();

       if(rs.next()){
           fs.setCurrentDirectory(new File("/home/me/Documents"));
           int tampak = fs.showSaveDialog(null);

           if (tampak == JFileChooser.APPROVE_OPTION){
               File file = fs.getSelectedFile();
                try (InputStream stream = rs.getBinaryStream("image");
                     OutputStream output = new FileOutputStream(file)) {

                    byte[] buffer = new byte[4096];
                    while (stream.read(buffer) > 0) {
                            output.write(buffer);
                    }
                }
           }
       }
       rs.close();
    } catch(FileNotFoundException fnfe){
      // FileNotFoundException handling
    } catch(IOException ioe) {
      // IOException handling
    } catch(SQLException sqle) {
     // SQLException handling
    }
}