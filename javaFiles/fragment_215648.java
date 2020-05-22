// org.apache.jmeter.threads.TestCompiler 

    private void saveSamplerConfigs(Sampler sam) {
        List<ConfigTestElement> configs = new LinkedList<>();
        List<Controller> controllers = new LinkedList<>();
        List<SampleListener> listeners = new LinkedList<>();
        List<Timer> timers = new LinkedList<>();
        List<Assertion> assertions = new LinkedList<>();
        LinkedList<PostProcessor> posts = new LinkedList<>();
        LinkedList<PreProcessor> pres = new LinkedList<>();
        for (int i = stack.size(); i > 0; i--) {
            addDirectParentControllers(controllers, stack.get(i - 1));
            List<PreProcessor>  tempPre = new LinkedList<>();
            List<PostProcessor> tempPost = new LinkedList<>();
            List<Assertion> tempAssertions = new LinkedList<>();
            for (Object item : testTree.list(stack.subList(0, i))) {
                if (item instanceof ConfigTestElement) {
                    configs.add((ConfigTestElement) item);
                }
                if (item instanceof SampleListener) {
                    listeners.add((SampleListener) item);
                }
                if (item instanceof Timer) {
                    timers.add((Timer) item);
                }
                if (item instanceof Assertion) {
                    tempAssertions.add((Assertion) item);
                }
                if (item instanceof PostProcessor) {
                    tempPost.add((PostProcessor) item);
                }
                if (item instanceof PreProcessor) {
                    tempPre.add((PreProcessor) item);
                }
            }
            assertions.addAll(0, tempAssertions);
            pres.addAll(0, tempPre);
            posts.addAll(0, tempPost);
        }

        SamplePackage pack = new SamplePackage(configs, listeners, timers, assertions,
                posts, pres, controllers);
        pack.setSampler(sam);
        pack.setRunningVersion(true);
        samplerConfigMap.put(sam, pack);
    }