boolean nonEmptyColleges = false;

for (int college: Databases.tblColleges.values()) {
    if (!college.tblDepartments.isEmpty()) {
        nonEmptyColleges = true;
        break;
    }
}