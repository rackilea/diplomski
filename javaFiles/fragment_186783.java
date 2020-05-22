interface RequestResponse<T>     {

    default void displayRequestResponse(Collection<? extends T> output) {
        output.foreach(this::displayRequestResponse);
    }

    void displayRequestResponse(T output);
}