public void setGlobalSetting(Setting setting) throws MyException {
    if(setting.getId() == 0) {
        try {
            ...
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Cannot set setting due to database error", e);
        }
    } else {
        ...
    }
}