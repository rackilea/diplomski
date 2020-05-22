@Parameterized.Parameters                                                                              
public static Collection<Object[]> getParameters() {                                            
    Collection<Object[]> params = new ArrayList<>(100);
    for(int i = 1; i <= 100; ++i) {
        params.add(new Object[] { i });
    }
    return params;
}