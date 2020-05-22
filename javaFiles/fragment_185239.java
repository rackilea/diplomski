boolean handled = false; 

handled = request.serviceLocalParameter("nondefault", request, response);

if (!handled) {
    handled = request.serviceLocalParameter("default", request, response);
}