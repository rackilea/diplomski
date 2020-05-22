ArrayList list = ...;
// List<object> list = ...;
foreach (object o in list) {
    if (o is int) {
        HandleInt((int)o);
    }
    else if (o is string) {
        HandleString((string)o);
    }
    ...
}