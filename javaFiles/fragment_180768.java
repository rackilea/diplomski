for (o <- args) {
      var names = LocalVariablesNamesTracer.getAllLocalVariableNames(o).toList
      for (name <- names) {
        templateHtmlBinding += (name -> o)
        templateTextBinding += (name -> o)
      }
    }