PriorityQueue<Foo> queue;
if(x_then_y_then_z) {
    queue = new PriorityQueue<Foo>(10, new XyzComparator());
} else if (y_then_x_then_z) {
    queue = new PriorityQueue<Foo>(10, new ZxyComparator());
}