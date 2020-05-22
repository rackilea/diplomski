class FilterState implements Serializable {
    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

class UserDataProvider implements IDataProvider<User>, IFilterStateLocator<FilterState> {

    private FilterState state;

    private UserDao userDao;

    public UserDataProvider() {
        state = new FilterState();
    }

    ....

    @Override
    public Iterator<? extends User> iterator(long first, long count) {
        //just some example filter logic, handled by the dao
        if (state == null || state.getRoles() == null) {
            return userDao.getUserList(first, count).iterator();
        } else {
            return userDao.getUserListByRoleName(state.getRoles(), first, count).iterator();
        }
    }

    @Override
    public FilterState getFilterState() {
        return state;
    }

    @Override
    public void setFilterState(FilterState state) {
        this.state = state;
    }

}