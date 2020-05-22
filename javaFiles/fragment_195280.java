Request Syntax:
GET /myaccount/Customers()?$filter=(Rating%20ge%203)%20and%20(Rating%20le%206)&$select=PartitionKey,RowKey,Address,CustomerSince  HTTP/1.1

Request Headers:
x-ms-version: 2013-08-15
x-ms-date: Mon, 25 Nov 2013 15:25:14 GMT
Authorization: SharedKeyLite myaccount:<some key>
Accept: application/atom+xml,application/xml
Accept-Charset: UTF-8
DataServiceVersion: 2.0;NetFx
MaxDataServiceVersion: 2.0;NetFx