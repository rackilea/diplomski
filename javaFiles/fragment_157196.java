.wireTap(new IntegrationFlow() {

        @Override
        public void configure(IntegrationFlowDefinition<?> x) {
            System.out.println(x);
        }

})