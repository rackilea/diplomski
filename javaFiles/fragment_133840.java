@SuppressWarnings("unchecked")
public <T extends Throwable> void throwSneakily(Throwable t) throws T {
    throw (T) t;
}

public void m() throws MyCheckedException {
    List<Parent> filtered = 
        list.stream()
            .peek(p -> { if (p == null) throwSneakily(new MyCheckedException()); })
            .filter(predicate)
            .collect(Collectors.toList());
}