public class SpanAdapter extends XmlAdapter<Object, Object> {

@Override
public Object unmarshal(Object o) throws Exception {
    if (o instanceof Span) {
        Span span = (Span) o;
        List<Span.Component> list = new ArrayList<>();
        for (Object child : span.getValue()) {
            if (child instanceof String) {
                String s = (String) child;
                for (String w : s.split(" ")) {
                    Word word = new Word();
                    word.setValue(w.trim());
                    list.add(word);
                }
            } else if (child instanceof Group) {
                list.add((Group) child);
            }
        }
        span.setValue(list);
        return span;
    }
    return o;
}

@Override
public Object marshal(Object o) throws Exception {
    if(o instanceof Span) {
        Span span = (Span) o;
        List list = new ArrayList<>();
        Iterator<Span.Component> iterator = span.getValue().iterator();
        while (iterator.hasNext()) {
            Span.Component w = iterator.next();
            if (w instanceof Group) {
                list.add(w);
            } else if (w instanceof Word) {
                String value = ((Word) w).getValue();
                list.add(iterator.hasNext() ? value + " " : value);
            }
        }
        span.setValue(list);
        return span;
    }else return o;
}
}