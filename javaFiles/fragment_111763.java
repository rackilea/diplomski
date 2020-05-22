import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

public class ASN1Handshake1 extends ASN1Object {

    private DERPrintableString a, b, idPass;

    private ASN1OctetString idK;

    // removed TTPs parameter (it wasn't using it)
    public ASN1Handshake1(String a, String b, String idK, String idPass) {
        this.a = new DERPrintableString(a);
        this.b = new DERPrintableString(b);
        this.idK = new DEROctetString(idK.getBytes());
        this.idPass = new DERPrintableString(idPass);
    }

    // returns a DERSequence containing all the fields
    @Override
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable[] v = new ASN1Encodable[] { this.a, this.b, this.idK, this.idPass };
        return new DERSequence(v);
    }
}