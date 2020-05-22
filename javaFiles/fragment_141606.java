private static boolean containsTeacherId(List<TeacherInfo> teacherInfos, int id) {
    for (TeacherInfo ti : teacherInfos) {
        if (ti.getId() == inputParam) { // I used getId(), replace that by the accessor you actually need
            return true;
        }
    }
    return false;
}