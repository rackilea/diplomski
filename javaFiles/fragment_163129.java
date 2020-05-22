<?xml version='1.0' encoding='UTF-8'?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <ns:getUserResponse xmlns:ns="http://www.cisco.com/AXL/API/10.0">
            <return>
                <user uuid="{SOME-IDENTIFIER-HERE}">
                    <firstName>MyFirstName</firstName>
                    <middleName />
                    <lastName>MyLastName</lastName>
                    <userid>myId</userid>
                    <password />
                    <pin />
                    <mailid>myEmail@myEmail.com</mailid>
                    <department />
                    <manager />
                    <userLocale />
                </user>
            </return>
        </ns:getUserResponse>
    </soapenv:Body>
</soapenv:Envelope>