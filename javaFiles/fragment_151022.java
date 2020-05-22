javax.net.ssl|DEBUG|01|main|2019-12-02 01:29:04.529 CET|CertificateMessage.java:358|Consuming server Certificate handshake message (
"Certificates": [
  "certificate" : {
    "version"            : "v3",
    "serial number"      : "75 20 46 4B 8D AC DC 10 08 00 00 00 00 1D 8A 52",
    "signature algorithm": "SHA256withRSA",
    "issuer"             : "CN=GTS CA 1O1, O=Google Trust Services, C=US",
    "not before"         : "2019-11-05 08:46:45.000 CET",
    "not  after"         : "2020-01-28 08:46:45.000 CET",
    "subject"            : "CN=www.google.com, O=Google LLC, L=Mountain View, ST=California, C=US",
    "subject public key" : "EC",
    "extensions"         : [
      {
        ObjectId: 1.3.6.1.4.1.11129.2.4.2 Criticality=false
      },
      {
        ObjectId: 1.3.6.1.5.5.7.1.1 Criticality=false
        AuthorityInfoAccess [
          [
           accessMethod: ocsp
           accessLocation: URIName: http://ocsp.pki.goog/gts1o1
        , 
           accessMethod: caIssuers
           accessLocation: URIName: http://pki.goog/gsr2/GTS1O1.crt
        ]
        ]
      },
      {
        ObjectId: 2.5.29.35 Criticality=false
        AuthorityKeyIdentifier [
        KeyIdentifier [
        0000: 98 D1 F8 6E 10 EB CF 9B   EC 60 9F 18 90 1B A0 EB  ...n.....`......
        0010: 7D 09 FD 2B                                        ...+
        ]
        ]
      },
      {
        ObjectId: 2.5.29.19 Criticality=true
        BasicConstraints:[
          CA:false
          PathLen: undefined
        ]
      },
      {
        ObjectId: 2.5.29.31 Criticality=false
        CRLDistributionPoints [
          [DistributionPoint:
             [URIName: http://crl.pki.goog/GTS1O1.crl]
        ]]
      },
      {
        ObjectId: 2.5.29.32 Criticality=false
        CertificatePolicies [
          [CertificatePolicyId: [2.23.140.1.2.2]
        []  ]
          [CertificatePolicyId: [1.3.6.1.4.1.11129.2.5.3]
        []  ]
        ]
      },
      {
        ObjectId: 2.5.29.37 Criticality=false
        ExtendedKeyUsages [
          serverAuth
        ]
      },
      {
        ObjectId: 2.5.29.15 Criticality=true
        KeyUsage [
          DigitalSignature
        ]
      },
      {
        ObjectId: 2.5.29.17 Criticality=false
        SubjectAlternativeName [
          DNSName: www.google.com
        ]
      },
      {
        ObjectId: 2.5.29.14 Criticality=false
        SubjectKeyIdentifier [
        KeyIdentifier [
        0000: 63 55 73 A0 9D C3 D5 FA   3C 1A 17 EA 0B 72 AB EF  cUs.....<....r..
        0010: D3 15 15 BB                                        ....
        ]
        ]
      }
    ]},
  "certificate" : {
    "version"            : "v3",
    "serial number"      : "01 E3 B4 9A A1 8D 8A A9 81 25 69 50 B8",
    "signature algorithm": "SHA256withRSA",
    "issuer"             : "CN=GlobalSign, O=GlobalSign, OU=GlobalSign Root CA - R2",
    "not before"         : "2017-06-15 02:00:42.000 CEST",
    "not  after"         : "2021-12-15 01:00:42.000 CET",
    "subject"            : "CN=GTS CA 1O1, O=Google Trust Services, C=US",
    "subject public key" : "RSA",
    "extensions"         : [
      {
        ObjectId: 1.3.6.1.5.5.7.1.1 Criticality=false
        AuthorityInfoAccess [
          [
           accessMethod: ocsp
           accessLocation: URIName: http://ocsp.pki.goog/gsr2
        ]
        ]
      },
      {
        ObjectId: 2.5.29.35 Criticality=false
        AuthorityKeyIdentifier [
        KeyIdentifier [
        0000: 9B E2 07 57 67 1C 1E C0   6A 06 DE 59 B4 9A 2D DF  ...Wg...j..Y..-.
        0010: DC 19 86 2E                                        ....
        ]
        ]
      },
      {
        ObjectId: 2.5.29.19 Criticality=true
        BasicConstraints:[
          CA:true
          PathLen:0
        ]
      },
      {
        ObjectId: 2.5.29.31 Criticality=false
        CRLDistributionPoints [
          [DistributionPoint:
             [URIName: http://crl.pki.goog/gsr2/gsr2.crl]
        ]]
      },
      {
        ObjectId: 2.5.29.32 Criticality=false
        CertificatePolicies [
          [CertificatePolicyId: [2.23.140.1.2.2]
        [PolicyQualifierInfo: [
          qualifierID: 1.3.6.1.5.5.7.2.1
          qualifier: 0000: 16 1C 68 74 74 70 73 3A   2F 2F 70 6B 69 2E 67 6F  ..https://pki.go
        0010: 6F 67 2F 72 65 70 6F 73   69 74 6F 72 79 2F        og/repository/

        ]]  ]
        ]
      },
      {
        ObjectId: 2.5.29.37 Criticality=false
        ExtendedKeyUsages [
          serverAuth
          clientAuth
        ]
      },
      {
        ObjectId: 2.5.29.15 Criticality=true
        KeyUsage [
          DigitalSignature
          Key_CertSign
          Crl_Sign
        ]
      },
      {
        ObjectId: 2.5.29.14 Criticality=false
        SubjectKeyIdentifier [
        KeyIdentifier [
        0000: 98 D1 F8 6E 10 EB CF 9B   EC 60 9F 18 90 1B A0 EB  ...n.....`......
        0010: 7D 09 FD 2B                                        ...+
        ]
        ]
      }
    ]}
]
)
javax.net.ssl|DEBUG|01|main|2019-12-02 01:29:04.566 CET|X509TrustManagerImpl.java:242|Found trusted certificate (
  "certificate" : {
    "version"            : "v3",
    "serial number"      : "04 00 00 00 00 01 0F 86 26 E6 0D",
    "signature algorithm": "SHA1withRSA",
    "issuer"             : "CN=GlobalSign, O=GlobalSign, OU=GlobalSign Root CA - R2",
    "not before"         : "2006-12-15 09:00:00.000 CET",
    "not  after"         : "2021-12-15 09:00:00.000 CET",
    "subject"            : "CN=GlobalSign, O=GlobalSign, OU=GlobalSign Root CA - R2",
    "subject public key" : "RSA",
    "extensions"         : [
      {
        ObjectId: 2.5.29.35 Criticality=false
        AuthorityKeyIdentifier [
        KeyIdentifier [
        0000: 9B E2 07 57 67 1C 1E C0   6A 06 DE 59 B4 9A 2D DF  ...Wg...j..Y..-.
        0010: DC 19 86 2E                                        ....
        ]
        ]
      },
      {
        ObjectId: 2.5.29.19 Criticality=true
        BasicConstraints:[
          CA:true
          PathLen:2147483647
        ]
      },
      {
        ObjectId: 2.5.29.31 Criticality=false
        CRLDistributionPoints [
          [DistributionPoint:
             [URIName: http://crl.globalsign.net/root-r2.crl]
        ]]
      },
      {
        ObjectId: 2.5.29.15 Criticality=true
        KeyUsage [
          Key_CertSign
          Crl_Sign
        ]
      },
      {
        ObjectId: 2.5.29.14 Criticality=false
        SubjectKeyIdentifier [
        KeyIdentifier [
        0000: 9B E2 07 57 67 1C 1E C0   6A 06 DE 59 B4 9A 2D DF  ...Wg...j..Y..-.
        0010: DC 19 86 2E                                        ....
        ]
        ]
      }
    ]}
)