public static void main(String[] args) {
        iNode res = list(5, 10);

        while(res != null){
            System.out.println(res.item);
            res = res.next;
        }
    }

    public static iNode list(int n, int m) {

        iNode previous;
        iNode current;

        int i = 0;
        previous = null;
        while (i < n) {
            current = new iNode(ThreadLocalRandom.current().nextInt(0, m), previous);
            previous = current;

            i++;
        }
        return previous;
    }