IdentifiableValue oldCountIdValue = mc.getIdentifiable( cacheKey );
if (oldCountIdValue != null) {
   return ( Long ) oldCountIdValue.getValue();
}

Long result = new Long( q.count() );
mc.putIfUntouched( cacheKey, oldCountValue, result );
return result;