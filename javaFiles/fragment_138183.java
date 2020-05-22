while (iter.hasNext()) {
    Object obj = iter.next();
    if (obj instanceof Something)
        return (Something)obj;
}
return null;