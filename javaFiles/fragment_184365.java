@Test
@RunIf(DatabaseIsConnected.class)
public void calculateTotalSalary() {
    //your code there
}

class DatabaseIsConnected implements Checker {
   public boolean satisify() {
        return Database.connect() != null;
   }
}