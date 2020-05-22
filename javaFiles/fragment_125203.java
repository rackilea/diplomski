try {
        FileReader fileReader =
                new FileReader(fileName);
        BufferedReader bufferedReader =
                new BufferedReader(fileReader);
        conn = getConnection();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement("insert into APP.Person(PERSON_ID, LAST_NAME, FIRST_NAME,STREET,CITY)values (?,?,?,?,?)");

        while((line = bufferedReader.readLine()) != null) {

            if ( line.trim().length() == 0 ) {
                continue;  // Skip blank lines
            }
            String[] splited = line.split(",");
            //System.out.println(line);
            id=splited[0];
            firstName=splited[1];
            lastName=splited[2];
            street=splited[3];
            city=splited[4];
            System.out.println(line);
            System.out.println(splited[4]);


            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, street);
            pstmt.setString(5, city);
            pstmt.addBatch();

        }
        pstmt.executeBatch();
        conn.commit();
        bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
        System.out.println(
                "Unable to open file '" +
                        fileName + "'");
        ex.printStackTrace();
    }
    catch(IOException ex) {
        System.out.println(
                "Error reading file '"
                        + fileName + "'");
    }