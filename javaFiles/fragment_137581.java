String getString(Object companyOrPeople) throws InvocationTargetException, IllegalAccessException
{
    if (companyOrPeople == null) {
        return "";
    }
    final Method getNmBn = companyOrPeople.getClass().getDeclaredMethod("getNmBn");
    final String nmBm = getNmBn.invoke(companyOrPeople).toString();
    // same with the other two methods
    return nmBm + "|" + nm + "#" + id;
}