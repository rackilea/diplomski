<%
ArrayList<String> students = teacherAccount .getStudents();
    Iterator<String> iterator = students .iterator();

    while (iterator.hasNext())
    {
      String student = (String)iterator.next();
      String pId = String.getId();
      ...
%>