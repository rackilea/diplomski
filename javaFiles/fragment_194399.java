@Then("target page was opened")
void targetPageWasOpened() {
    waitFor {
        withWindow({ isAt TargetPage }) { true }
    }
}