PriorityQueue<EventPoint> events = new PriorityQueue<EventPoint>();
BinarySearchTree<Interval> intervalTree = new BinarySearchTree<Interval>();

// Initialize all the start events, and include the corresponding circle.    
for (Circle c : circles) {
    events.add(EventPoint.start(c.x, c));
}

while (!events.isEmpty()) {

    // Remove the minimum (leftmost) event from the queue
    EventPoint ep = events.poll();

    switch (ep.type) {

        case START:
            Circle current = ep.circle;
            // (Look for intersections in the interval tree...)

            // Create an interval and add it to the interval tree
            Interval interval = new Interval(current.y, current.y +
                    current.height);
            intervalTree.add(interval);

            // Add an end-event to the queue, and include the interval for
            // later removal.
            events.add(EventPoint.end(current.x + current.width, interval));

            break;

        case END:
            // Remove the interval from the interval tree.
            intervalTree.remove(ep.interval);
            break;
    }
}