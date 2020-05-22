Element defs = doc.createElementNS(svgNS, "defs");

Element fontface = doc.createElementNS(svgNS, "font-face");
fontface.setAttributeNS(null, "font-family", "DroidSansRegular");

Element fontfacesrc = doc.createElementNS(svgNS, "font-face-src");
Element fontfaceuri = doc.createElementNS(svgNS, "font-face-uri");

fontfaceuri.setAttributeNS(svgNS, "xlink:href", "fonts/DroidSans-webfont.svg#DroidSansRegular");

Element fontfaceformat = doc.createElementNS(svgNS, "font-face-format");
fontfaceformat.setAttributeNS(svgNS, "string", "svg");

fontfaceuri.appendChild(fontfaceformat);
fontfacesrc.appendChild(fontfaceuri);
fontface.appendChild(fontfacesrc);
defs.appendChild(fontface);
svgRoot.appendChild(defs);