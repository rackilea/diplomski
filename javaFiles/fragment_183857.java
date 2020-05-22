DateFormat df = null;
if(recievedDate.indexOf("//")!=-1){
    df = new SimpleDateFormat("dd/MM/yyyy")
}else{
    df = new SimpleDateFormat("yyyyMMddhhmmss")
}