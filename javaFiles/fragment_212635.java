import org.bouncycastle.pqc.jcajce.interfaces.StateAwareSignature;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.pqc.jcajce.spec.XMSSMTParameterSpec;
import org.bouncycastle.util.Strings;

import java.security.*;

public class Main {

    private static void fail(boolean condition, String msg) {
        if (condition) {
            throw new RuntimeException(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastlePQCProvider());
        byte[] msg = Strings.toByteArray("Cthulhu Fthagn --What a wonderful phrase!Cthulhu Fthagn --Say it and you're crazed!");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("XMSSMT", "BCPQC");

        kpg.initialize(new XMSSMTParameterSpec(20, 10, XMSSMTParameterSpec.SHA256), new SecureRandom());

        KeyPair kp = kpg.generateKeyPair();

        Signature sig = Signature.getInstance("SHA256withXMSSMT", "BCPQC");

        fail(!(sig instanceof StateAwareSignature), "wrong signature instance");

        StateAwareSignature xmssSig = (StateAwareSignature) sig;

        xmssSig.initSign(kp.getPrivate());

        fail(!xmssSig.isSigningCapable(), "signature object is not signing-capable");

        xmssSig.update(msg, 0, msg.length);

        byte[] s = sig.sign();

        PrivateKey nKey = xmssSig.getUpdatedPrivateKey();

        fail(kp.getPrivate().equals(nKey), "");
        fail(xmssSig.isSigningCapable(), "signature object is signing-capable");

        xmssSig.update(msg, 0, msg.length);

        try {
            sig.sign();
            fail(true, "no exception after key extraction");
        } catch (SignatureException e) {
            fail(!"signing key no longer usable".equals(e.getMessage()), "wrong exception");
        }

        try {
            xmssSig.getUpdatedPrivateKey();
            fail(true, "no exception after key extraction");
        } catch (IllegalStateException e) {
            fail(!"signature object not in a signing state".equals(e.getMessage()), "wrong exception");
        }

        xmssSig.initSign(nKey);

        xmssSig.update(msg, 0, msg.length);

        s = sig.sign();

        xmssSig.initVerify(kp.getPublic());

        xmssSig.update(msg, 0, msg.length);

        fail(!xmssSig.verify(s), "verification failure");
    }
}