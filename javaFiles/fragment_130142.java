while(!stack.empty()) {
        String char1 = stack.pop();
        String char2 = queue.dequeue();
        if (!(char1.equalsIgnoreCase(char2))) {
            diff++;
        }
    }