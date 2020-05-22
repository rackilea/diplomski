while ((line = reader.readLine()) != null) {
    try {
        String[] tokens = line.split("");
        for (int i = 0; i != tokens.length; i++) {
            int dataIndex = tokens[i].indexOf('=') + 1;
            String data = tokens[i].substring(dataIndex);
            hm1.put(new Integer(i),data);
        }
        // Try to parse line and insert into db
        preparedStmt.setString(1, hm1.get(19));
        preparedStmt.setString(2, hm1.get(19));
        // etc....
        // No other try/catch here to skip entire 
        // line on error
        preparedStmt.execute();
    }
    catch (SQLException e1) {
        e1.printStackTrace();
    }
    catch (IOException e2) {
        e2.printStackTrace();
    }
    catch (ParseException e3) {
        System.out.println("e3.getmessage()");
    }
} // while