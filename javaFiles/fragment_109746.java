class TaskTest extends spock.lang.Specification {
  def "should print test to stdout"() {
    given:
    def expected = 'expectedOutput'
    System.out = Mock(PrintStream)
    Project project = ProjectBuilder.builder().build()
    def task = project.task('testTask', type: Task)

    when:
    task.execute()

    then:
    1 * System.out.println(expected)
  }
}