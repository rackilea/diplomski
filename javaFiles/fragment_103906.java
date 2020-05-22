int tmp = 1; // ******
        while (rs.next()) {
           dbtime = rs.getString(weq);
           System.out.println(dbtime);
           celDatas[tmp][weq - 1] = dbtime;
           tmp++;
        } // end while