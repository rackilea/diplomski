if (n != null)
{
    if(name.compareTo(n.getVehicleName()) < 0))
    {
        if(name.hasLeft()){
            return find(name.left, n);
        }else{
            return null
        }
    }
    else if((name.compareTo(n.getVehicleName()) > 0))
    {
        if(name.hasRight()){
            return find(name.right, n);
        }else{
            return null
        }
    }
    else if(name.compareTo(n.getVehicleName()) == 0)
    {
        return Vehicle;
    }
}