@XmlRootElement(name="node")
    class Node implements Comparable<Node> {
        @XmlElement(name="order-id")
        int orderId;

        @Override
        public int compareTo(Node n) {
            return orderId - n.orderId;
        }
    }

    @XmlRootElement(name="root")
    class Root {
        @XmlElement(name="node")
        Set<Node> nodes = new TreeSet<>(); 
    }