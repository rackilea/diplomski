package org.bc.sample;

import java.math.BigInteger;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class ECPointAddition
{
    public static void main(String[] args)
    {
        BigInteger prime = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564821041");
        BigInteger A = new BigInteger("7");
        BigInteger B = new BigInteger("43308876546767276905765904595650931995942111794451039583252968842033849580414");

        ECCurve curve = new ECCurve.Fp(prime, A, B);

        BigInteger Px = new BigInteger("2");
        BigInteger Py = new BigInteger("4018974056539037503335449422937059775635739389905545080690979365213431566280");
        BigInteger Qx = new BigInteger("57520216126176808443631405023338071176630104906313632182896741342206604859403");
        BigInteger Qy = new BigInteger("17614944419213781543809391949654080031942662045363639260709847859438286763994");

        // Explicit affine addition
        ECFieldElement xp = curve.fromBigInteger(Px), yp = curve.fromBigInteger(Py);
        ECFieldElement xq = curve.fromBigInteger(Qx), yq = curve.fromBigInteger(Qy);
        ECFieldElement alpha = yq.subtract(yp).divide(xq.subtract(xp));
        ECFieldElement xr = alpha.square().subtract(xp).subtract(xq);
        ECFieldElement yr = xp.subtract(xr).multiply(alpha).subtract(yp);

        System.out.println("EXPLICIT");
        System.out.println(xr.toBigInteger().toString(10));
        System.out.println(yr.toBigInteger().toString(10));

        // Point addition using built-in formulae
        ECPoint P = curve.createPoint(Px, Py);
        ECPoint Q = curve.createPoint(Qx, Qy);
        ECPoint R = P.add(Q).normalize();

        System.out.println("BUILT-IN");
        System.out.println(R.getAffineXCoord().toBigInteger().toString(10));
        System.out.println(R.getAffineYCoord().toBigInteger().toString(10));
    }
}