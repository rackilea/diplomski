protected void closeQuietly( Resource resource ) {
      try {
        if (resource != null) {
          resource.close();
        }
      } catch( Exception ex ) {
        log( "Exception during Resource.close()", ex );
      }
    }