AsyncContext cntx = request.startAsync(request, response);

long timeOut = DEFAULT_TIME_OUT;


if( req.getParameterMap().containsKey( TIME_OUT ) ){
    try {
        timeOut = Long.parseLong( req.getParameter( TIME_OUT ) );
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
}

cntx.setTimeout( timeOut );