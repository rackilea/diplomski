public E next() {
            if (currentIndex >= size()) {
                currentIndex = 0;
            }
            return items[currentIndex++];
        }