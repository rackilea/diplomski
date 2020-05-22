MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
credentialHandler.setAlgorithm("SHA-512");
String salt = "5e0bdcf374c9c36b8930f23579ca0297";
int iterations = 5;
String hexPassword = "2c72f01ce132a1d070e67ad4730f3c26dba6d1dce7d32c6d8fe127afc952cd02308bdbdd45333e71f4dfed57bc5288ce501da30228907b9d49f5932896c025a2";
credentialHandler.matches("password", salt + "$" + iterations + "$" + hexPassword);
-> true