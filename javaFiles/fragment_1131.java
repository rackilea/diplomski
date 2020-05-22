public  String login()
{
  ...
  getServletRequest().getSession().setAttribute("idClient", client.getIdClient()); 

public  String  show()
{
  System.out.println(getServletRequest().getSession().getAttribute("idClient"));