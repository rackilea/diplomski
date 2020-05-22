for (j = 0; j < rows; j++) {
            String query = " INSERT INTO schedule ([counter],[description]) VALUES ('" + j + "','" + itemss[j][1] + "') ";
            st.executeUpdate(query);
            System.out.println(query);
        }

    } catch (Exception e) {
        //no logging
    }