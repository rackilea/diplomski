class Runner {

    @Autowired @Qualifier("implForRq1")
    private MyInterface runnerOfRq1;

    @Autowired @Qualifier("implForRq2")
    private MyInterface runnerOfRq2;

    void run(int rq) {
        switch (rq) {
            case 1: runnerOfRq1.run();
            case 2: runnerOfRq2.run();
            ...

        }
    }

}

...

@Autowired
Runner runner;

void run(int rq) {
    runner.run(rq);
}