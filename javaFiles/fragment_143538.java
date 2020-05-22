LocalDate from = LocalDate.now().minusYears(1); // 2018-04-29
LocalDate to = LocalDate.of(Year.now().getValue(), Month.JUNE, 1); // 2019-06-01

String sql = "SELECT * FROM students WHERE dateadded BETWEEN ? AND ? AND c_occupation = 'Student'";
pst = conn.prepareStatement(Sql);
pst.setObject(1, from);
pst.setObject(2, to);