doAnswer(invocation -> {
       Object arg1 = invocation.getArguments()[0];
       Object arg2 = invocation.getArguments()[1];

       if(arg1 instanceof Integer && arg2 instanceof String)
           return "something";
        if(arg1 instanceof String && arg2 instanceof Boolean)
            return false;

        return false;
}).when(yourmock).deepCopy(any(), any());