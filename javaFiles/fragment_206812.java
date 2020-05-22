ObjectOutputStream out = new ObjectOutputStream(fbos) {
    {
        enableReplaceObject(true);
    }

    @Override
    protected Object replaceObject(Object arg0) throws IOException {
        // TODO Auto-generated method stub
        if(arg0 instanceof Type) {
            for(Constructor<?> constructor : arg0.getClass().getConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if(parameterTypes.length == 0 /* Number of arguments in the constructor of new Type(...) */)
                    try {
                        return constructor.newInstance(/* Arguments to the constructor */);
                    } catch (InstantiationException | IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException e) {
                        e.printStackTrace();
                    }
            }

            try {
                throw new Exception("The constructor needed to create a new Type was not found.");
            } catch(Exception e) {
                e.printStackTrace();
            }

            return null;

        } else {
            return super.replaceObject(arg0);
        }
    }
};
out.writeObject(orig);
out.flush();
out.close();