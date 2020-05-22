//where you now push named files as a json  
  return [namedFiles as JSON].toString()

  // or alternatively in gsp javascript segment something like this
  var results=$.parseJSON('<%=namedFiles.encodeAsJSON()%>');
  var results = results['patient1']