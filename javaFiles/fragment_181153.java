afterEvaluate {
    jacoco {
        applyTo testUnit
        applyTo testIntegration
    }
    testIntegration.extensions.getByName("jacoco").excludes = ['*Test*', '*.?', '*Foo*', 'jodd.asm5.*', '*.fixtures.*']
}