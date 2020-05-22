POST https://<CRM DOMAIN>.com/api/data/v8.1/accounts HTTP/1.1
Content-Type: application/json; charset=utf-8
Accept: application/json
Authorization: Bearer:<TOKEN GOES HERE>
Host: <CRM DOMAIN>.com
Content-Length: 224

{
    "name": "Sample Account",
    "creditonhold": false,
    "address1_latitude": 47.639583,
    "description": "This is the description of the sample account",
    "revenue": 5000000,
    "accountcategorycode": 1
}