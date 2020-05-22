<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix=”student” tagdir=”/WEB-INF/tags/student” %>

<!DOCTYPE html>
<html>
  <head>
    <title>Students</title>
  </head>
  <body>
    <form>
      (other inputs)
      ...
      <student:select studentList="${sessionScope.studentList}" />
      ...
      (other inputs)
    </form>
  </body>
</html>