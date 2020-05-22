while (queue.size() > 1) {
        Node least1 = queue.poll();
        Node least2 = queue.poll();
        Node combined = new Node(least1.frequency + least2.frequency);
        combined.right = least1;
        combined.left = least2;
        least1.parent = combined;
        least2.parent = combined;
        queue.add(combined);
        // Keep track until we actually find the root
        root = combined;
}