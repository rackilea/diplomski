KeyUsage ku = new KeyUsage(KeyUsage.digitalSignature);
Extension kuExt = new Extension(Extension.keyUsage, true, ku.getEncoded());
ExtendedKeyUsage eku = new ExtendedKeyUsage(KeyPurposeId.id_kp_serverAuth);
Extension ekuExt = new Extension(Extension.extendedKeyUsage, true, eku.getEncoded());
Extensions exts = new Extensions(new Extension[] {kuExt, ekuExt});
builder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, exts);