XmlDocument soapEnvelop = new XmlDocument();
    soapEnvelop.LoadXml(@"<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ConversionRate xmlns="http://www.webserviceX.NET/">
      <FromCurrency>USD</FromCurrency>
      <ToCurrency>GBP</ToCurrency>
    </ConversionRate>
  </soap:Body>
</soap:Envelope>");

HttpWebRequest webRequest = CreateWebRequest(_url, _action);
using (Stream stream = webRequest.GetRequestStream())
    {
        soapEnvelopeXml.Save(stream);
    }