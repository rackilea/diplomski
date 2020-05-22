if ( model.isFileLoaded() ){
     enable buttons
} else {
      disable all buttons except the load
      if ( model.hadError() ) {
          display helpful message (and let user specify a different file)
      }
}