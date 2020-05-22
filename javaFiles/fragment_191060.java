public Building implements HtmlRepresentable {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<p>");
        sb.append (this.getDesc());
        sb.append ("which contains: <br> <ul>"); 
        for (Room r: this.getRooms()) {
            sb.append("<li>" + r.getDesc() + "</li>");
        }
        sb.append("</ul>");
        return sb.toString(); 
}