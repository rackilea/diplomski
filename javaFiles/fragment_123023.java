154   // only parse HTML responses
  155   if (extendedResponse.getContentType() != null && isValidContentType(extendedResponse.getContentType()))
  156   {
        ...
  172        // writes the response
  173        addResource.writeResponse(extendedRequest, servletResponse);
  174    }
  175   else
  176   {
  178        byte[] responseArray = extendedResponse.getBytes();
  180        if(responseArray.length > 0)
  181       {
  182       // When not filtering due to not valid content-type, deliver the byte-array instead of a charset-converted string.
  183       // Otherwise a binary stream gets corrupted.
  184       servletResponse.getOutputStream().write(responseArray);
  185     }