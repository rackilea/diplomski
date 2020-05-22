interface I1 {
    public void x() throws I1Exception, I2Exception;
}

interface I2 {
    public void x() throws I2Exception;
}