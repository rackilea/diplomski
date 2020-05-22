public class MyCoolException extends Exception {
    public MyCoolException() {
    }
    public MyCoolException(String message) {
        this.message = message;
    }
}

public interface DataDAO {
    public void doSomething() throws MyCoolException;
}

public class DataDAOJdbc implements DataDAO {
    public void doSomething() throws MyCoolException {
         //Implement
         try {
         } catch (SQLException e) {
             //handle the exception
             logger.error("Error!", e);
             //throw your custom exception
             throw new MyCoolException(e.getMessage());
         }
    }
}

public class DataDAOWebService implements DataDAO {
    public void doSomething() throws MyCoolException {
         //Implement
         try {
         } catch (IOException e) {
             //handle the exception
             logger.error("Error!", e);
             //throw your custom exception
             throw new MyCoolException(e.getMessage());
         }
    }
}