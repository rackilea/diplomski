smooks.addVisitor(new SAXVisitAfter() {
        @Override
        public void visitAfter(SAXElement element,
                ExecutionContext executionContext) throws SmooksException,
                IOException {
            MyElement element = (MyElement) executionContext.getBeanContext()
                    .getBean("myElement");
            // send 'element' here;
        }
    }, "root/element");