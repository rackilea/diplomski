ResultSet rs = pst.executeQuery();
    List<String> allQuestions = new ArrayList<>();
    while(rs.next())
    {
        allQuestions.add(rs.getString("Question"));
    }
    if (allQuestions.isEmpty()) {
        System.out.println("No data for this subject");
    } else {
        Random random = new Random();
        question.setText(allQuestions.get(random.nextInt(allQuestions.size())));
    }