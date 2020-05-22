SwingWorker<Void, Void> worker = new SwingWorker< Void, Void>() {

        String[] billItems = null;

        @Override
        public Void doInBackground() {

            String SQL = "SELECT * FROM AddABill";

            try {
                Statement stmt = GlobalVars.conn.createStatement();

                ResultSet rs = stmt.executeQuery(SQL);

                //Set The Cursor To Last Position
                rs.last();

                int totalRows = rs.getRow();

                billItems = new String[totalRows];

                //Set The Cursor Back To The Start
                rs.beforeFirst();

                while(rs.next()){
                    int rowNum = rs.getRow() - 1;
                    billItems[rowNum] = rs.getString(1) + " - " + rs.getString(2);
                }

                rs.close();
                stmt.close();
            }

            catch (SQLException e) {
                System.out.println("An Error Was Detected! :/");
            }

            return null;
        }

        @Override
        public void done(){
            menuOptions.clear();

            for(int i = 0; i < billItems.length; i++){
                menuOptions.addElement(billItems[i]);
            }

            loadingGif.setVisible(false);
        }

    };