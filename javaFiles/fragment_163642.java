boolean hasMyName = false;

    while (iter.hasNext()) {
       item = iter.next();
       String fileName =  item.getName();
       String fieldName = item.getFieldName();
       if (item.isFormField()) {
          String fieldValue = Streams.asString(item.openStream());
          if (fieldName.equals("myname")){ //validating Hidden form tag name
             hasMyName = true;
          }
    }

    if ( hasMyName ) {
        // myname is present, do something
    }