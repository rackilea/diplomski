MaybeReader m = new MaybeReader(...);
if (m.failed(ds.longitude = m.maybeReadInt(ds.longitude))
    || m.failed(ds.latitude = m.maybeReadInt(ds.latitude))
    || m.failed(ds.velocity = m.maybeReadShort(ds.velocity)) {
  return ds;
}