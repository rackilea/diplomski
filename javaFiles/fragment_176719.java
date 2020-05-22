public class SetParam1StepListener implements StepExecutionListener {

    protected String param1;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        stepExecution.getExecutionContext().put("param1", this.param1); 

    }

}



<beans:bean id="value1.setParam1StepListener" class="com.my.SetParam1StepListener" p:param1="value1" />