@Override
    public ReturnData registerUser(Users user) {
      // TODO Auto-generated method stub
    ReturnData returnData = new ReturnData(); 

    Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Users WHERE emailID = :email_ID OR mobileNo = :mobile_No");
    query.setString("email_ID", user.getEmailID());
    query.setString("mobile_No", user.getMobileNo());

    if(((long)query.uniqueResult()) > 0)
    {
        returnData.setResult(false);
        returnData.setMessage("Email or Mobile number already exists");
        return returnData;
    }
    else
    {
        Query query =       this.sessionFactory.getCurrentSession().createSQLQuery("");
        query.executeUpdate();
        returnData.setResult(true);
        returnData.setMessage("User Registered Successfully");
        return returnData;
    }
}