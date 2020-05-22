/**
  * @author IncredibleCoding
  */
public class Client
{
protected int cod;
protected String name;

/**
  * instance the code passed
  */
public void setCod(int cod) throws Exception
{
  if(cod==null)
  throw new Exception("Invalid code!");

  this.cod = cod;
}

/**
  * @returns the code
  */
public int getCod()
{
  return this.cod;
}

/**
  * instance the name passed
  * @param name, that is the name passed
  * @throws Exception, if the name is in invalid format
  */
public void setName(String name) throws Exception
{
  if(name==null || name.equals("")
  throw new Exception("Invalid name!");

  this.name = name;
}

/**
  * @returns the name 
  */
public String getName()
{
  return this.name;
}

/**
  * the constructor
  * @param cod, that is the code passed
  * @param name, that is the name passed
  */
public Client(int cod, String name) throws Exception
{
  this.setCod(cod);
  this.setName(name);
}

/**
  * @param obj, that is the object that will be compared
  * @returns true if the object is equal to this, false if the object isn't equal
  */
public boolean equals(Object obj)
{
  if(this==obj)
  return true;

  if(obj==null)
  return false;

  if(!(obj instanceof Client))
  return false;

  Client client = (Client)obj;

  if(this.cod!=client.cod)
  return false;

  if(this.name!=client.name)
  return false;

  return true;
}

/**
  * returns the formatted variable like String
  */
public String toString()
{
  return "Code: " + this.cod + "\n" +
         "Name: " + this.name;
}

/**
  * returns the hashCode of a variable
  */
public int hashCode()
{
  int ret = 444;

  ret += ret*7 + new Integer (this.cod).hashCode();
  ret += ret*7 + (this.name).hashCode();

  return ret;
}

/**
  * clone the object
  */
public Object clone()
{
  Client ret = null;

  try
  {
     ret = new Client(this);
  }
  catch(Exception error)
  {
   // this is never null 
  }

  return ret;
}

/**
  * "copy" the variables
  * @param model, that is the object that will be copied
  * @throws Exception, if the model is inexistent
  */
public Client(Client model) throws Exception
{
  if(model==null)
  throw new Exception("Inexistent model!");

  this.cod = model.cod;
  this.name = model.name;
}

}