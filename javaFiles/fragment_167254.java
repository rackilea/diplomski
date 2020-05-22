void reportError(IResource resource, int line, String msg) {
   IMarker m = resource.createMarker(IMarker.PROBLEM);
   m.setAttribute(IMarker.LINE_NUMBER, line);
   m.setAttribute(IMarker.MESSAGE, msg);
   m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
   m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
}