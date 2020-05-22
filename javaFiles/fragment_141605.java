List<TeacherInfo> teacherInfo=ServiceManager.getHelperService(TeacherManagementHelper.class, request, response).getTeacherInfoId();
if (teacherInfo.stream().anyMatch(ti -> ti.getId() == inputParam)) {
    // contains the id
} else {
    // does not contain the id
}