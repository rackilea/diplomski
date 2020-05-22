void domainSpring() {
    DescribedPredicate<JavaAnnotation> springAnnotationPredicate = new DescribedPredicate<JavaAnnotation>("Spring filter") {
        @Override
        public boolean apply(JavaAnnotation input) {
            return input.getType().getPackageName().startsWith("org.springframework");
        }
    };
    classes().that().resideInAPackage(DOMAIN_LAYER).should()
            .notBeAnnotatedWith(springAnnotationPredicate).check(CLASSES);

}