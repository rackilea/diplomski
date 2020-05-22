boolean nonEmptyColleges = false;

for (int key: Databases.tblColleges.keySet()) {
    if (!Databases.getTblColleges(key).tblDepartments.isEmpty()) {
        nonEmptyColleges = true;
        break;
    }
}