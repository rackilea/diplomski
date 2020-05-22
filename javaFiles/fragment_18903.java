import java.util.*;
import java.security.SecureRandom;

public class StudentCalls {
    private final Set<String> students = new HashSet<>();
    private final List<String> callPool = new ArrayList<>();
    private static final Random rand = new SecureRandom();

    public void addStudent(String name) {
        int studentCount = students.size();
        if (!students.add(name))
            throw new IllegalArgumentException(name + " has already been added");
        int newStudentCalls = studentCount == 0 ? 1 // bootstrap
                // average of already present students', never less than 1
                : (int) Math.round((double) callPool.size() / studentCount);
        for (int i = 1; i <= newStudentCalls; i++)
            callPool.add(name);
    }

    public void addStudents(String... names) {
        for (String name : names)
            addStudent(name);
    }

    public void removeStudent(String name) {
        if (!students.remove(name))
            throw new IllegalArgumentException("Unknown student: " + name);
        callPool.removeAll(Collections.singleton(name));
    }

    public String nextCall() {
        int poolSize = callPool.size();
        if (poolSize == 0)
            throw new IllegalStateException("No students to choose from");
        int poolIndex = rand.nextInt(poolSize);
        /* Below is optimized equivalent of this code:
        String selectedStudent = callPool.remove(poolIndex);
        if (!callPool.contains(selectedStudent))
            callPool.addAll(students);
        */
        String selectedStudent = callPool.get(poolIndex);
        if (Collections.frequency(callPool, selectedStudent) > 1) {
            String lastInPool = callPool.remove(--poolSize);
            if (poolIndex < poolSize)
                callPool.set(poolIndex, lastInPool);
        } else
            for (String student : students)
                if (!student.equals(selectedStudent))
                    callPool.add(student);
        return selectedStudent;
    }

    public void conductClasses(int numberOfCalls) {
        for (int i = 0; i < numberOfCalls; i++)
            System.out.println(nextCall());
        System.out.println();
    }

    public static void main(String[] args) {
        StudentCalls sc = new StudentCalls();
        sc.addStudents("Josh", "Cooper", "Rachel", "Buckley", "Matt",
                "Lucy", "Kristin", "Kyle", "Kelly");
        sc.conductClasses(20);
        sc.removeStudent("Matt");
        sc.conductClasses(15);
        sc.addStudent("Cliff");
        sc.conductClasses(25);
    }
}