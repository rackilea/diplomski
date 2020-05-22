public class FilterEntity implements Serializable {
public int ageFrom;
public int ageTo;
public String sex;
public String status;


public void setAgeFrom()
{
    this.ageFrom = ageFrom;
}

public void setAgeTo()
{
    this.ageTo = ageTo;
}

public void setSex()
{
    this.sex = sex;
}

public void setStatus()
{
    this.status = status;
}

public Integer getAgeFrom()
{

    return ageFrom;
}

public Integer getAgeTo()
{
    return ageTo;
}

public String getSex()
{
    return sex;
}

public String getStatus()
{
    return status;
}
}