public void actionPressed()
  {
    if( isLoading )
      return;
    try {
    isLoading= true;
    doTheLoad);
    } finally {
    isLoading = false;
    }    
  }