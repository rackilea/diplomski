public void myJavaMethod () {
...
if( condition ){
RequestContext context = RequestContext.getCurrentInstance();
context.execute("PF('myDialogVar').show();"); 
} else {
RequestContext context = RequestContext.getCurrentInstance();
context.execute("PF('myDialogVarOther').show();");      
}    
...    
}