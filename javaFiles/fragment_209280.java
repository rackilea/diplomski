public String toString() {
        StringBuilder sb = new StringBuilder(this.word);
        LinkedList tmp = this;
        while (tmp.next != null) {
            sb.append(" > ");
            tmp = tmp.next;
            if (tmp.word != null)
                sb.append(tmp.word);
        }
        return sb.toString();
    }