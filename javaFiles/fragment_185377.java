package my.packagename;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.*;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public enum TaskGroup {
    IMPOSSIBLE,
    EASY,
    COOL;

    static {
        Class<?> creatorBase = TaskCreator.class;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Set<ClassInfo> infoSet = ClassPath.from(loader).getTopLevelClassesRecursive("my.packagename");
            for (ClassInfo info : infoSet) {
                Class<?> cls = info.load();
                if (creatorBase.isAssignableFrom(cls) && !Modifier.isAbstract(cls.getModifiers()))
                    Class.forName(cls.getName()); // runs static initializer for cls
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final List<TaskCreator> creators = new ArrayList<>();

    public void register(TaskCreator task) {
        creators.add(task);
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        for (TaskCreator creator : creators)
            tasks.add(creator.createTask());
        return tasks;
    }
}