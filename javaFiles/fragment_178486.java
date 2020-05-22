try {
String myResult=root.busybox();  
if(myResult!=null&&myResult.length>0) {

    Busybox.setText(Html.fromHtml((myResult)));


}
else {

    Busybox.setText(Html.fromHtml((getString(R.string.no))));

    }
}