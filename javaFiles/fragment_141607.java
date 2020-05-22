List<TeacherInfo> teacherInfo=ServiceManager.getHelperService(TeacherManagementHelper.class, request, response).getTeacherInfoId();
if (containsTeacherId(teacherInfo, inputParam)) {
    // contains the id
} else {
    // does not contain the id
}