import java.util.List;
import bo.ICustomerBo;
import dao.ICustomerDao;
import model.Customer;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class CustomerBoImpl implements ICustomerBo{

    ICustomerDao customerDaoImpl;



    public ICustomerDao getCustomerDaoImpl() {
        return customerDaoImpl;
    }

    public void setCustomerDaoImpl(ICustomerDao customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }

@Transactional(readOnly = false)
@Override
    public void addCustomer(Customer customer){

        getCustomerDaoImpl().addCustomer(customer);

    }

@Transactional(readOnly = false)
@Override
    public void updateCustomer(Customer customer){
        getCustomerDaoImpl().updateCustomer(customer);
    }

@Transactional(readOnly = false)
@Override
    public void deleteCustomer(Customer customer){
        getCustomerDaoImpl().deleteCustomer(customer);
    }

@Override
    public List<Customer> findAllCustomer(){

        return getCustomerDaoImpl().findAllCustomer();
    }
}