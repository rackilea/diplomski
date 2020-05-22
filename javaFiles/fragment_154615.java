DwrService.getThings({
  callback:function(things){
    for(thing in things){
      YAHOO.augmentProto(thing, my.beautiful.package.MyClass);
    }
    // do your stuff here
  }
});