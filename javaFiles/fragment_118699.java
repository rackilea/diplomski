Future {
    dateFormatDv.withValue(new SimpleDateFormat("yyyy-dd-MM HH:mm:ss")) {
      doStuffWithDateFormat(dateFormatDv.value)
      doMoreStuffWithTheSameFormatInstance(dateFormatDv.value)
    }          
  }

  Future {
    dateFormatDv.withValue(new SimpleDateFormat("yyyy-dd-MM HH:mm:ss")) {
      useADifferentInstanceOfDateFormat(dateFormat.value)
    }
  }