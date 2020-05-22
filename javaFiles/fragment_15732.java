String ActualDeliveryDate;
if (theItem.getType() == Item.DATETIMES)
{
 DateTime dt = theItem.getDateTimeValue();
 ActualDeliveryDate = dt.getLocalTime();
}
else
{
 ActualDeliveryDate =  orderRegelDocument.getItemValueString("ActualDeliverydate");
}