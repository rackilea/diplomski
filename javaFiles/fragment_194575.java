@FacesConverter(forClass = Organization.class, value = "organizationConverter")
public class OrganizationConverter implements Converter
{

@Override
public Object getAsObject(FacesContext fc, UIComponent uic, String id)
{
    if (StringUtils.isEmpty(id))
    {
        return null;
    }
    // Convert id to an Organizacion
    return organization;
}

@Override
public String getAsString(FacesContext fc, UIComponent uic, Object o)
{
    if (o instanceof Organization)
    {
        return ...;//Convert organization to id
    }
    return null;
}

}