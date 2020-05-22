<%  

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();

%>
<body>
          <input required type="date" name="datepicker" value="<%=objDate%>">
</body>