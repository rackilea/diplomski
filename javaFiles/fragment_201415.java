public class TD0301AssignmentForm extends Form {  

    public Object insert(HttpServletRequest request) {
        TD0301Assignment tdas = new TD0301Assignment();

        try {
            tdas.setCalcNum(FormUtil.getFieldValue(request, FIELD_CALC_NUM));
            processDate(request, tdas);

            tdas.setCalcDept(FormUtil.getFieldValue(request, FIELD_CALC_DEPT));
            tdas.setYearOi(Integer.toString(DateUtil.getIntYear(dateNow)));
            processCalcSafetyRequirements(request, tdas);

            if (isSuccess()) {
                WorkflowInstance wf = buildWorkflow(tdas);
                tdas.setWorkflowInstanceId(wf.getId());
            }
        }
    }

    private buildWorkflow(TD0301Assignment tdas) {
        WorkflowInstance wfi = new WorkflowInstance();
        wfi.setWorkflowClassId(tdas.getCalcLevel());
        wfi.setStartedBy(authenticatedUser.getBadge());
        wfi.setStatus("0");
        wfi.setLastDate(new Date());

        WorkflowInstanceDao wfiDao = new WorkflowInstanceDao();
        wfiDao.insert(wfi, authenticatedUser);
    } 

}