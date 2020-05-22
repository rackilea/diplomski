// static header you can put in front
byte[] header = Hex.decode("30 81bf 020100 301006072a8648ce3d020106052b81040022 0481a7");
// your key from the PEM above
byte[] fromPEM = Base64.decode("MIGkAgEBBDD2MFRv6BpJU6/zDI2yBfVbe0oeU1nFAoYMedDGtcdwHyWNJSeiYRBApVNzMxPSBLWgBwYFK4EEACKhZANiAAQBttEp/qUGnDlmL+o6KZnVs+RoBnEBEGhoPxSUu1Xfj77QQqfuqHOCRzWXseQA1aZB/h6VQEiFovugtG1G3HaMxxrqLLxb10g2BMaRcAfZyeqc3O0Ui8XXb1esn0gOrCU=");
byte[] bytes = Arrays.concatenate(header, fromPEM);
PrivateKey ecPrivate = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bytes));