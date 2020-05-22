class Database1 implements Database<Long> { 
    @Override
    public Long createNode(...) { 
        ...
        long result = // obtain id of created node
        return result;
    }

    @Override
    public void modifyNode(Long id, ...) { 
        ...
        // use id
    }
}