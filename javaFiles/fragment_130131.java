@Override
protected void executeImpl(Action action, NodeRef actionedUponNodeRef) {
    if (condition) {
    // Do something
    } else {
           throw new WebScriptException("Action is failed");                        
           }
    }