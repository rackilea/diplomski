@Override
public String toString() {
    StringBuffer sb = new StringBuffer(10 * this.count); // Complete guess
    ListenElement el = this.first;
    while (el != null) {
        sb.append(el.content.toString());
        el = el.next;
        if (el != null) {
            sb.append(", ");
        }
    }
    return sb.toString();
}