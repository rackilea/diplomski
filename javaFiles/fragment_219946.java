// (configuring the default `test` task of the `java` plugin here; works with
// any task of Gradle’s `Test` type, though)
test {
    reports {
        junitXml {
            outputPerTestCase = true
        }
    }
}