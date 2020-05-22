for (int i =0; i < listeners.size(); i++) { 
    Listener l = listeners.get(i);
    if (l == null) 
        continue;
    l.handleEvent();
}