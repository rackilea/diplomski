class WrapperStringArray {
    private String[] arr;

    //constructors, getters, setter and additional methods

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WrapperStringArray other = (WrapperStringArray) obj;
        return Arrays.equals(arr, other.arr);
    }   
}