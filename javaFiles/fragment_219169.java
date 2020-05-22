// before the for loop, create a list of type Step
List<Step> steps = new ArrayList();
// your loop on response received from server
for (int i = 0; i < response.body().getRes().getToday().size(); i++) {
    if (response.body().getRes().getToday().get(i).getType().equals("penny")) {
        StepDynamicEdt = stepDynamicEdt = new StepDynamicEdt(response.body().getRes().getToday().get(i).getName());
        // add to list
        steps.add(stepDynamicEdt);
    } else if (response.body().getRes().getToday().get(i).getType().equals("best")) {
        StepDynamicTxt = stepDynamicTxt = new StepDynamicTxt(response.body().getRes().getToday().get(i).getName());
        // add to list
        steps.add(stepDynamicTxt);
    }
}
// finally create them
stepper.setup(new StepperFormListener() {
    @Override
    public void onCompletedForm() {

    }

    @Override
    public void onCancelledForm() {

    }
}, steps) // pass the list
        .allowNonLinearNavigation(false)
        .displayCancelButtonInLastStep(false)
        .displayBottomNavigation(false)
        .confirmationStepTitle("Confirm")
        .stepNextButtonText("Continue")
        .lastStepNextButtonText("Finish")
        .includeConfirmationStep(false)
        .init();