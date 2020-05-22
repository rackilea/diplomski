ResultSet rs = newSelectClassesQuery.GetClassesList(query); // already closed!
totalClasses = FXCollections.observableArrayList();
while(rs.next()) // exception
{
    // AvailableClasses classesData = new AvailableClasses();
    classBox.getItems().add(rs.getString("class_name"));
}
rs.close();