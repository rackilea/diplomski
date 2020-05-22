public Testplan kek2() {
        Testplan testplan = Testplan.builder()
                .name("System test")
                .entries(Lists.newArrayList(Entry.builder()
                        .name("Custom run name")
                        .suiteId(1)
                        .includeAll(false)
                        .caseIds(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))
                        .build()))
                .build();
        System.out.println(testplan);
        return testplan;
    }