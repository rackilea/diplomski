public T dequeue() {
        if(list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        T result = list.remove(0);
        return result;
   }