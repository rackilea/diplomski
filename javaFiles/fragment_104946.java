public class Result<T> {
    // Prevent anyone except the Builder class from instantiating
    // this class by making the constructor private.
    private Result(T result) {}

    public static class Builder<T>
    {
        private T result;

        public void setResult(T result)
        {
            this.result = result;
        }

        public Result<T> build()
        {
            return new Result(result);
        }
    }

    public Result<T> set() {
        return this;
    }
}