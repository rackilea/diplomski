public class ManageStudent{

    enum OPERATION {
        CREATE, UPDATE, DELETE
    }

    public static void doOperation(Student student, OPERATION op) {
        switch (op) {
        case CREATE: {
            System.out.println("perfrom create operation");
            break;
        }
        case UPDATE: {
            System.out.println("perfrom update operation");
            break;
        }
        case DELETE: {
            System.out.println("perfrom delete operation");
            break;
        }
        default:
            // throw some meaningful exception
        }
    }
}