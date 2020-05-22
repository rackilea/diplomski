elements = doc.getElementsByTagName(tag);  
Element el = (Element) elements.item(0);  
String id = el.getAttribute("Id");  

//Reference ref = fac.newReference("".concat(id), fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);  
Reference ref = fac.newReference("#" + id, fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);