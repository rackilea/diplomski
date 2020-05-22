if (resultSet == 0) {
            sql.close();
            resultSet.close();
            return false;
        }
        sql.close();
        resultSet.close();
        return true;