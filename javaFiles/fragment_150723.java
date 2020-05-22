for(Category c = this; c != null; c=c.parent) {
  synchronized(c) {  // LOCKED HERE
    if(c.aai != null) {
      writes += c.aai.appendLoopOnAppenders(event);
    }
    if(!c.additive) {
      break;
    }
  }
}