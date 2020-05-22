public class CustomStack<T> {
    private class CustomNode<U> {
        private U data;
        private CustomNode<U> next;

        public CustomNode(U data) {
            this.data = data;
        }   
    }
}