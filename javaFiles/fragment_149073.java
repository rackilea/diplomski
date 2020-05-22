public String getCreatedAt()
{
    Calendar c1 = Calendar.getInstance();      
    String msg_time= c1.get(Calendar.YEAR) + c1.get(Calendar.MONTH) + c1.get(Calendar.DAY_OF_MONTH) + c1.get(Calendar.HOUR_OF_DAY) + c1.get(Calendar.MINUTE);
    return msg_time;
}