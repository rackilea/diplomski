MIME-Version: 1.0
 Content-Type: Multipart/Related;boundary=MIME_boundary;
 ...
 --MIME_boundary
 Content-Type: application/xop+xml; 
 ...

 <soap:Envelope ...
  <soap:Body>...
    <foo>
      <photo xmlmime:contentType='image/png'>
        <xop:Include xmlns:xop='http://www.w3.org/2004/08/xop/include' 
           href='cid:http://example.org/me.jpeg'/></m:photo>
 ...

 --MIME_boundary
 Content-Type: image/png
 Content-Transfer-Encoding: binary
 Content-ID: <http://example.org/me.png>

 // binary octets for png