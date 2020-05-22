try {

            PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.Szyby_temp(nr_zlec_klienta, nr_ref_klienta, szerokosc, wysokosc, ilosc, opis_dodatkowy, data_importu) VALUES(?, ?, ?, ?, ?, ?, getdate())");
            for (String[] row : rows) {
                int i = 0;
                for (String columnValue : row) {    
                    ps.setString(++i, columnValue); //Parameter indexes start with 1
                }
                ps.addBatch();
            }
            ps.executeBatch(); //if number of rows in csv file is not divisible by maxbatchSize
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }