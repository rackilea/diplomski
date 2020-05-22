resultSet = statement.executeQuery(queryString);

        /**********************************/
        /** your result set is never null */
        /** this is incorrect             */
        /**********************************/
        if (resultSet != null) {
            //if the query returns any rows set boolean to true
            search.setEmployeeFound(true);
            //...
        }