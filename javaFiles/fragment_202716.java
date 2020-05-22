dos.writeBytes("Content-Disposition: form-data; name=\"parameter\"" + lineEnd); 
        //dos.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd);
        //dos.writeBytes("Content-Length: " + parameter.length() + lineEnd);
        dos.writeBytes(lineEnd);
        dos.writeBytes(parameter); // mobile_no is String variable
        dos.writeBytes(lineEnd);