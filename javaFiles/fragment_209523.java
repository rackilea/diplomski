onclick() {
    if (people < 1 || people > 100) {
        showToast();
        return;
    }
    if (other-validation-condition == false) {
        showOtherToast();
        return;
    }
    if (yet-another-validation-condition == false) {
        showYetAnotherToast();
        return;
    }
    // now, everything should be valid...
    continueDoingStuffWithValidatedValues();
}