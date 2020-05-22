Elements elements = document.getElementsByTag("name");
StringBuilder sb = new StringBuilder();
for(Element e : elements) {
    sb.append(e.text()).append(", ");
}
desc = sb.toString();