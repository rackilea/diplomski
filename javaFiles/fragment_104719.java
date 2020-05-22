-        try {
    -            increaseDormantActivations();
    -            decreaseActiveActivations();
    +        try {
    +            increaseDormantActivations();
    +            decreaseActiveActivations();
    +            
    +            for (FactHandle factHandle : activation.getFactHandles())
    +                if (!((InternalFactHandle) factHandle).isValid())
    +                    return;