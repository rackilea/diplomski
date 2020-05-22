private void searchBook(final String title, final String author, final String Genre) {

    Map<String, String> validParams = new HashMap<String, String>();

    if (!title.equals("")) {

        validParams.put("title", title);
    }
    if (!author.equals("")) {

        validParams.put("author", author);
    }
    if (!Genre.equals("")) {

        validParams.put("genre", Genre);
    }

    if(validParams.isEmpty()){
        // if no value is correct, return
        return;

    }

    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("SELECT name from BOOK  ");
    boolean queryBuildStarted = false ;

    for(String key : validParams.keySet()){

        if(!queryBuildStarted){
            queryBuilder.append(" WHERE ");
            queryBuildStarted = true;
        }
        else{
            queryBuilder.append(" AND ");

        }


        queryBuilder.append(key+" = ?");
    }


    PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());

    int index = 1;

    for(String key : validParams.keySet()){

        statement.setString(index, validParams.get(key));
        index ++;
    }


    ResultSet rs = statement.executeQuery();
    // do stuff
}