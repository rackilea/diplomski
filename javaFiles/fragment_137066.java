POST /some-resource HTTP/1.1
Content-Type: multipart/form-data; boundary=AaB03x

--AaB03x
Content-Disposition: form-data; name="json"
Content-Type: application/json

{ "foo": "bar" }

--AaB03x--
Content-Disposition: form-data; name="image"; filename="image.jpg"
Content-Type: application/octet-stream

... content of image.jpg ...

--AaB03x--