import groovy.ui.SystemOutputInterceptor

class TaskTest {
    @Test
    void testSomething() {
        def expected = 'expectedOutput'
        def actual ='';
        def interceptor = new SystemOutputInterceptor({ actual += it; false});

        Project project = ProjectBuilder.builder().build()
        def task = project.task('testTask', type: Task)

        interceptor.start()
        task.execute()
        interceptor.stop()

        assert actual.trim() == expected
    }
}