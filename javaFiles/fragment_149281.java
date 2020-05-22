Scanner scanner = new Scanner(System.in);

String[] questions = {
        "What is your name?",
        "What is your quest?",
        "What is your favorite color?",
        "What is the capital of Assyria?",
        "What is the velocity of an unladen swallow?"
};

String[] cache = new String[questions.length];

BehaviorSubject<Integer> index = BehaviorSubject.create(0);

index
.observeOn(Schedulers.trampoline())
.concatMap(idx -> {
    if (idx == questions.length) {
        index.onCompleted();
        return Observable.empty();
    }

    System.out.println(questions[idx]);
    String answer = scanner.nextLine().trim();

    if ("BACK".equals(answer)) {
        index.onNext(Math.max(0, idx - 1));
        return Observable.empty();
    } else
    if ("QUIT".equals(answer)) {
        index.onCompleted();
        return Observable.empty();
    }

    cache[idx] = answer;
    index.onNext(idx + 1);
    return Observable.just(answer);
})
.subscribe(v -> System.out.println("You said: " + v));