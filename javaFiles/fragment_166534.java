import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class User {
    private String ID;
    private String userName;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        User bean = new User();
        bean.setUserName("name");
        System.out.println(BeanUtils.getProperty(bean, "userName"));
    }
}