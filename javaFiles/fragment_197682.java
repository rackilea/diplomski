String parameter;
    try {
        ...
    } catch (Exception e) {
        logFailure(e, parameter);
        throwException(e);
    }

    public void throwException(Exception e) throws Exception{
       if (e instanceof X) {
            throw new A(e);
        } else if (e instanceof Y
                || e instanceof Z) {
            throw new B(e);
        } 
        throw new InternalServerErrorException(e);
    }