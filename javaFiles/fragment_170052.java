Completion myLazyCompletion;

void methodB() {
    methodA(myLazyCompletion != null ? myLazyCompletion :
        (myLazyCompletion = new Completion() {

            // overrides

        })
    );
}