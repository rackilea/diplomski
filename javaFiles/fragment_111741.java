StringBuilder s = new StringBuilder();
boolean first = true;   

for (String tag : selected_tags)  {
    if (!first)
        s.append("%");
    else
        first = false;

    s.append(tag);
}

String myUrlString = "tags=" + s.toString();