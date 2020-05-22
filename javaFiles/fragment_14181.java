comboExecution.setItemCaptionGenerator(new ItemCaptionGenerator<TestExecution>() {
        @Override
        public String apply(TestExecution execution) {
            return execution.getName();
        }
    });