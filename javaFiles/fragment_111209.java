ext.libraries = [
    commons_io: "commons-io:commons-io:2.4"
  , jasperreports: dependencies.create('net.sf.jasperreports:jasperreports:5.1.0') {
        exclude group: 'com.lowagie'
        exclude group: 'jfree'
  }
  , cxf: [
        'org.apache.cxf:cxf-rt-frontend-jaxws:3.1.4'
      , 'org.apache.cxf:cxf-rt-transports-http:3.1.4']
]