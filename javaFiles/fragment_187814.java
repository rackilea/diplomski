public class TestJarSigner {

 public static void main(String[] args) {
  JarSigner signer = new JarSigner();
  signer.run(new String[] { "-verify", "tools.jar" });
 }

}