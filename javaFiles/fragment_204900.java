MusicBrainzReleaseWrapper wrapper = session.get(release.getId()):
//the wrapper is managed object
if (wrapper == null) {
  //initilize wrapper with the values from release
  .......
  session.save(wrapper)
}
else {
   // do not set ID here. ID is aready present!!!
   //  never manuay set the version field here
   wrapper.setName(release.getTitle().toLowerCase(Locale.UK));
   wrapper.setXmldata(sw.toString());
   session.saveOrUpdate(wrapper);
   //In case you don't need update logic at all
   // remove the @Version field from the entity
   // and do othing in the else clause , or throw exception
   // or log error or anything you see fit
}