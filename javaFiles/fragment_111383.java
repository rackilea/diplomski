SingleSubject<Integer> subject1 = SingleSubject.create();

TestObserver<Integer> to1 = subject1.test();

// SingleSubjects are empty by default
to1.assertEmpty();

subject1.onSuccess(1);

// onSuccess is a terminal event with SingleSubjects
// TestObserver converts onSuccess into onNext + onComplete
to1.assertResult(1);

TestObserver<Integer> to2 = subject1.test();

// late Observers receive the terminal signal (onSuccess) too
to2.assertResult(1);