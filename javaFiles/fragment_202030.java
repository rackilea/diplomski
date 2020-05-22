@XmlRootElement(name = "Department")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class DepartmentBean {

    @XmlElement(name = "Emp", type = UserBean.class)
    @XmlElementWrapper(name = "Emps")
    private List<UserBean> users;

    public List<UserBean> getUsers() {
        return users;
    }

    public void addIfAbsent(UserBean userBean) {
        if (users.stream().anyMatch(x -> x.getUsername().equals(userBean.getUsername()))) {
            System.err.println("User " + userBean + " is already exist, do nothing");
        } else {
            users.add(userBean);
        }
    }
}