List<Object> getUniqueColumn(String column_name,String column_text){
        StringBuilder query = new StringBuilder();
        query.append("select #column_name ");
        query.append("from Item ");
        query.append("where #column_name like %?1%");

        query = query.toString("#column_name", column_name);

        session.createQuery(query).setString(1, column_text).list();
}