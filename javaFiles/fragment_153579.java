IMarker marker = file.createMarker(IMarker.PROBLEM);

marker.setAttribute(IMarker.LINE_NUMBER, line number of the error);
marker.setAttribute(IMarker.MESSAGE, "your error message");
marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);