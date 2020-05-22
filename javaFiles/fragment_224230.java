if (!(
    "Ford".equals(make)   || "Honda".equals(make) || "Toyota".equals(make) || 
    "Chrysler".equals(make) || "Other".equals(make))) 
{
        throw (new UsedCarException());
}