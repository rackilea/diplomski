public SPN(PriorityQueue<Process> prq) {
    System.out.println(prq.size());
    Iterator<Process> iter = prq.iterator();
    while (iter.hasNext()) {
        Process p = iter.next();
        System.out.println(p.getName() + "'s rem time: "
                + p.getRemTime());
        iter.remove();
        System.out.println("Actual size: " + prq.size());
    }
}