m.setAccessible(true); // bypass access
        try
        {
            m.invoke(new MyClass(), null); // invoke method (you have to know parameter types and pass them if needed. Use *Method.getParameter...()* methods for that.
        }
        catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e)
        {
            e.printStackTrace();
        }