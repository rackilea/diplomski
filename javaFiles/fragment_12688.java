===================================================================
--- src/main/java/com/amazonaws/http/HttpClientFactory.java     (thirdparty/aws)      (revision 20105)
+++ src/main/java/com/amazonaws/http/HttpClientFactory.java     (thirdparty/aws)    (working copy)
@@ -93,7 +93,7 @@

                        SSLSocketFactory sf = new SSLSocketFactory(
                                SSLContext.getDefault(),
-                               SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
+                               SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);