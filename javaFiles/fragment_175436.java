public static void generateBookList(){
        try {
            Connection connection = ConnectToDatabase.createConnection();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from book ");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    //You are actually using the same object again and again.
                    // Following line is important.
                    BookBean x = new BookBean(resultSet.getInt("id_book"), resultSet.getString("title"), resultSet.getString("author"));
                    listBooks.add(x);

                    System.out.println(listBooks.get(0).getId());
                    System.out.println(listBooks.get(0).getTitle());
                    System.out.println(listBooks.get(0).getAuthor());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }