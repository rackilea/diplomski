String sqlQuery = "INSERT INTO Incident "
            + "(customer_id, unit_id, place_id, "
            + "incidentType_id, createDate ) "
            + "VALUES ("+ this.customer.id +","+ this.unit.id +","+ this.place.id +","
            + this.incidentType.id +",'"+ Index.getDate("yyyy-MM-dd HH:mm:ss") + "')" ;
Query tempQuery = JPA.em().createNativeQuery(sqlQuery);
tempQuery.executeUpdate();