scheduler.getListenerManager().addTriggerListener(new TriggerListener() {

    private Date lastFireTime = null;

    @Override
    public String getName() {
        return "prevent-duplicate-fires";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        final Date fireTime = context.getScheduledFireTime();
        if (lastFireTime != null && fireTime.equals(lastFireTime)) {
            return true;
        }
        lastFireTime = fireTime;
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
    }
});