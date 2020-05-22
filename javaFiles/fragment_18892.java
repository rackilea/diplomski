@Test
public void badTestWhichVerifiesPrivateConstructorIsCalled()
{
    new Expectations(Task.class) {{ // partially mocks `Task`
        // Records an expectation on a private constructor:
        newInstance(Task.class, "name");
    }};

    Task task = Task.getInstance("name");

    assertNotNull(task);
}

@Test
public void goodTestWhichVerifiesTheNameOfANewTask()
{
    String taskName = "name";

    Task task = Task.getInstance(taskName);

    assertNotNull(task);
    assertEquals(taskName, task.getName());
}

@Test
public void goodTestWhichVerifiesANewTaskIsCreatedEverytime()
{
    Task task1 = Task.getInstance("name1");
    Task task2 = Task.getInstance("name2");

    assertNotNull(task1);
    assertNotNull(task2);
    assertNotSame(task1, task2);
}