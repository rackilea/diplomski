{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "javaType": "com.walmart.services.tesseract.service.request.models.inkiru.PaymentHead",
  "properties": {
    "payments": {
      "type": "array",
      "items":
        {
          "type": "object",
          "properties": {
            "paymentHandle": {
              "type": "string"
            },
            "txndate ": {
              "type": "string"
            },
            "ordernumber": {
              "type": "string"
            },
            "stgOrderNumber": {
              "type": "string"
            }
          }
        }
    }
  }
}