public static class User
{
    public User(int userId, int roleId)
    {
        this.userId = userId;
        this.roleId = roleId;
    }
    private int userId;
    private int roleId;
    public int getUserId()
    {
        return userId;
    }
    public int getRoleId()
    {
        return roleId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
}