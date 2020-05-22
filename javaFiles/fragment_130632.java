// the same as above

userNameTokenElm.addChildElement(userNameElm);
userNameTokenElm.addChildElement(passwdElm);
SOAPElement el = sh.addChildElement(wsSecHeaderElm); // addChildElement returns new SOAPElement!
el.addChildElement(userNameTokenElm);