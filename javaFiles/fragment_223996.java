for (Iterator iter = collection.iterator(); iter.hasNext();) {
            Object item = iter.next();
            if (predicate.evaluate(item)) {
                return item;
            }
        }