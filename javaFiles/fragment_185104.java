if (slotDesc.hasWriteObjectMethod()) {
 // through reflection it will call the Serializable objects writeObject method
} else {
// the below is the same method called by defaultWriteObject method also.
writeSerialData(obj, desc);
}