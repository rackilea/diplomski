### Send a form with the text and file fields
POST https://httpbin.org/post
Content-Type: multipart/form-data; boundary=WebAppBoundary

--WebAppBoundary
Content-Disposition: form-data; name="Name"

myName

--WebAppBoundary
Content-Disposition: form-data; name="category"

myCategory

--WebAppBoundary
Content-Disposition: form-data; name="data"; filename=".gitignore"
Content-Type: application/json

< ./.gitignore
--WebAppBoundary--

<> 2019-09-23T045805.200.json

###