String nonceStr = UUID.create(); 
System.out.println("nonceStr: "+nonceStr); 
byte[] a = Base64.decodeBase64(nonceStr.getBytes()); 
System.out.println("nonceStr: "+Base64.encodeBase64String(a)); 


String base64NonceStr = new String(Base64.encodeBase64(nonceStr.getBytes())); 
System.out.println("base64NonceStr: "+base64NonceStr); 
byte[] b = Base64.decodeBase64(base64NonceStr.getBytes()); 
System.out.println("base64NonceStr: "+Base64.encodeBase64String(b)); 

nonceStr: ac1c6f1cc80f4cbde9f753bfd5f0fa 
nonceStr: ac1c6f1cc80f4cbde9f753bfd5f0fQ== 
base64NonceStr: YWMxYzZmMWNjODBmNGNiZGU5Zjc1M2JmZDVmMGZh 
base64NonceStr: YWMxYzZmMWNjODBmNGNiZGU5Zjc1M2JmZDVmMGZh 

nonceStr: ac1c6f1c2da679b7dea1384b81fb2431 
nonceStr: ac1c6f1c2da679b7dea1384b81fb2431 
base64NonceStr: YWMxYzZmMWMyZGE2NzliN2RlYTEzODRiODFmYjI0MzE= 
base64NonceStr: YWMxYzZmMWMyZGE2NzliN2RlYTEzODRiODFmYjI0MzE= 

nonceStr: ac1c6f1cc80f4cbdea17677b796ad8 
nonceStr: ac1c6f1cc80f4cbdea17677b796adw== 
base64NonceStr: YWMxYzZmMWNjODBmNGNiZGVhMTc2NzdiNzk2YWQ4 
base64NonceStr: YWMxYzZmMWNjODBmNGNiZGVhMTc2NzdiNzk2YWQ4