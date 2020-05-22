@Stateless
public class MyFacade {
    @EJB
    private MyFacade self;

   public void deleteEmployeeData(Set<Employees> deleted) throws DatabaseException {
     ...
     try {
       self.deleteEmployee(emp);
     } catch (Exception ex) {
       // ...
     }
     ...
   }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void deleteEmployee(Employees emp) {
      this.remove(emp);
    }

}