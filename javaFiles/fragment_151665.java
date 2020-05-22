MyObject myObj = new MyObject(); // must be serializable

Cipher cipher;
/* initialize fully with IV, key and Cipher.ENCRYPT_MODE */

/* encrypt `myObj` */
SealedObject sealedObj = new SealedObject(myObj, cipher);

/* decrypt `sealedObj` */
MyObjct decryptedObj = (MyObject) sealedObj.get(key); // `key` = encryption-key