public void MyMethod(Relation myRelation) {
...
while (!queue.isEmpty()) {
        Element pivot = queue.poll();
        elements.remove(pivot);
        for (Element a : elements) {
            if (myRelation.execute(pivot, a)) {
                db.addRelation(a, pivot);
                queue.add(a);
                elements.remove(a);
            }
        }
    }

...
}