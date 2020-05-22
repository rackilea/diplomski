fn.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
            try {
                System.out.println(t1);
                String getAllFines1 = "SELECT * FROM fines WHERE fine_name='" + t1 + "'";
                ResultSet rs1 = handler.execQuery(getAllFines1);
                while (rs1.next()) {
                    InputStream is = rs1.getBinaryStream("fine_image");
                    BufferedImage imBuff = ImageIO.read(is);
                    image = SwingFXUtils.toFXImage(imBuff, null);
                    imageView.setImage(image);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UpdateFinesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UpdateFinesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });