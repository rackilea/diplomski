StringBuilder buf = new StringBuilder()
        .append("foo");
if (doBar)
    buf.append("bar");
buf.append("baz");
Html.fromHtml(buf.toString());