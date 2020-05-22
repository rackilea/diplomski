public boolean contains(String searching)
{
    for(ParkingSlot slot : slots)
    {
         if(slot.getCar()!=null)
             if (slot.getCar().getRegistrationNumber().equals(searching))
                 return true;
    }
    return false;
}