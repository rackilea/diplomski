package my.packagename;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> impossible = TaskGroup.IMPOSSIBLE.getTasks();
        for (Task task : impossible)
            System.out.println("Impossible task: " + task.getName());
        System.out.println();

        List<Task> easy = TaskGroup.EASY.getTasks();
        for (Task task : easy)
            System.out.println("Easy task: " + task.getName());
        System.out.println();

        List<Task> cool = TaskGroup.valueOf("COOL").getTasks();
        for (Task task : cool)
            System.out.println("Cool task: " + task.getName());
        System.out.println();

        // Can iterate through groups
        for (TaskGroup group : TaskGroup.values())
            System.out.println("Group " + group + " has " + group.getTasks().size() + " task(s)");

        // Can easily get a specific Task through its creator
        Task haltingProblemTask = HaltingProblem.INSTANCE.createTask();
    }
}