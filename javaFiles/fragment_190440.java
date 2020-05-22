if(fname!=null || uname!=null ...){

    if (pw.equals(pw1) ) {
  //your insert code put here 
    }else{
     out.println("<div class='alert-message alert-message-warning' align='center'>"+
        "<h4>Alert Message Warning</h4>"+
        "<p>Confirmed Password Doesn't Match With the Password <br>" +
            "<strong>Please Re-Type Your Password</strong>."+
        "</p></div>");
  }


}else{

  out.println("<div class='alert-message alert-message-warning' align='center'>"+
            "<h4>Alert Message Warning</h4>"+
            "<p>Some Fields Are Empty <br>" +
                "<strong>Please Fill All The Fields</strong>."+
            "</p></div>");


}