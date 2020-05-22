let myXML = [];
myXML.push('<root><hdr>' + jsonIn.hdr + '</hdr>\r\n');
myXML.push('<itm>' + jsonIn.item[0] + '</hdr></root>');
// ...

// When you're ready for the big string:
myXML = myXML.join("");