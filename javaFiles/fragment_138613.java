import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String... args) {

        App app = new App();

        try {
            app.run();

        } catch (UserNotFoundException e) {
            System.out.println("'USER_NOT_FOUND'");
        } catch (TodoNotFoundException e) {
            System.out.println("'TODO_NOT_FOUND'");
        } catch (AppException e) {
            System.out.println("Some other application exception");
        }
    }

    DataService dataService = null;

    public void run() throws AppException {

        System.out.println("This will run always");

        prepareDataService();

        completeTodo(1, 2);

        System.out.println("this should only run if a user was returned");

    }

    void prepareDataService() {

        List<Todo> todoList = new ArrayList<Todo>();
        List<User> userList = new ArrayList<User>();

        dataService = new DataService(todoList, userList);
    }

    void completeTodo(int todoId, int userId) throws AppException {

        Todo todo = dataService.findTodo(todoId);
        User user = dataService.findUser(userId);

        user.doSomething(todo);
    }
}

class DataService {

    private List<Todo> todoList;
    private List<User> userList;

    public DataService(List<Todo> todoList, List<User> userList) {
        this.todoList = todoList;
        this.userList = userList;
    }

    public Todo findTodo(int todoId) throws TodoNotFoundException {
        Todo todo = null;

        // find todo here

        if (todo == null) {
            throw new TodoNotFoundException("todo " + todo + " not found");
        }
        return todo;
    }

    public User findUser(int userId) throws UserNotFoundException {
        User user = null;

        // find user here

        if (user == null) {
            throw new UserNotFoundException("user " + user + " not found");
        }
        return user;
    }
}

class Todo {
}

class User {

    public void doSomething(Todo todo) {
    };
}

class AppException extends Exception {
    public AppException(String msg) {
        super(msg);
    }
}

class TodoNotFoundException extends AppException {
    public TodoNotFoundException(String msg) {
        super(msg);
    }
}

class UserNotFoundException extends AppException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}