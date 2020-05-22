SSLSocket s = SSLSocketFactory.getDefault() /* or other */ .createSocket("host", 443);
SSLParameters p = s.getSSLParameters();
p.setServerNames( new ArrayList<SNIServerName>() );
/* or j9+ p.setServerNames( List<SNIServerName>.of() ); */
s.setSSLParameters(p);
...