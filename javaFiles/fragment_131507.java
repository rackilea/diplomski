FileInputStream fileInputStream=new FileInputStream(new File(fileName));
ObjectInputStream stream=new ObjectInputStream(fileInputStream);
for(Employee emp : (ArrayList)stream.readObject())
{
    String uName = emp.getUserId();
    String uPass = emp.getPassword();
    map.put(uName, uPass);
}