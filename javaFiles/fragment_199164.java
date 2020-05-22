String s = 
        "00020001 OB #2 [00\\01] File Meta Information Version\r\n" + 
        "00020002 UI #26 [1.2.840.10008.5.1.4.1.1.4] Media Storage SOP Class UID\r\n" + 
        "00020003 UI #62 [1.3.46.670589.11.0.0.11.4.2.0.8743.5.5396.2006120114483570701] Media Storage SOP\r\n" + 
        "00020010 UI #20 [1.2.840.10008.1.2.1] Transfer Syntax UID";
System.out.println(s.replaceAll("(?m)^(\\d+).*", "$1"));