// get data
if(request.IsDraft){
    draftRequestHandler.Modify(request);
}
else{
    publishedRequestHandler.Modify(request);
}