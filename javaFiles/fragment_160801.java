public static <AdapterType> AdapterType adapt(Object adaptableObject, Class<AdapterType> adapterType)
{
  if (adaptableObject == null)
    return null;

  // Is the object the desired type?

  if (adapterType.isInstance(adaptableObject))
    return adapterType.cast(adaptableObject);

  // Does object adapt to the type?

  if (adaptableObject instanceof IAdaptable)
   {
     AdapterType result = adapterType.cast(((IAdaptable)adaptableObject).getAdapter(adapterType));
     if (result != null)
       return result;
   }

  // Try the platform adapter manager

  return adapterType.cast(Platform.getAdapterManager().getAdapter(adaptableObject, adapterType));
}