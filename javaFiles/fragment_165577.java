for (BeanPropertyDefinition bpd : beanPropertyDefinitions) {
    AnnotatedMember annotatedMember = bpd.getAccessor();
    Member member = annotatedMember.getMember();
    if (member instanceof Method) {
        Method getterMethod = (Method) member;
        System.out.println(getterMethod.getName());
    }
}