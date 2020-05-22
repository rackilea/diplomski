static double radiusearthkm, ao, ainv, con42, cosio, sinio, cosio2, eccsq,
        omeosq, posq, rp, rteosq,
        cnodm, snodm, cosim, sinim, cosomm, sinomm, cc1sq,
        cc2, cc3, coef, coef1, cosio4, day, dndt,
        em, emsq, eeta, etasq, gam, argpm, nodem,
        inclm, mm, nm, perige, pinvsq, psisq, qzms24,
        rtemsq, s1, s2, s3, s4, s5, s6,
        s7, sfour, ss1, ss2, ss3, ss4, ss5,
        ss6, ss7, sz1, sz2, sz3, sz11, sz12,
        sz13, sz21, sz22, sz23, sz31, sz32, sz33,
        tc, temp, temp1, temp2, temp3, tsi, xpidot,
        xhdot1, z1, z2, z3, z11, z12, z13,
        z21, z22, z23, z31, z32, z33,
        qzms2t, ss, j2, j3oj2, j4, x2o3, //r[3], v[3],
        tumin, mu,  xke, j3;


public static boolean sgp4init(
        SGP4unit_a.Gravconsttype whichconst, char opsmode, final int satn, final double epoch,
        final double xbstar, final double xecco, final double xargpo,
        final double xinclo, final double xmo, final double xno,
        final double xnodeo, SGP4SatData satrec)
{

    double[] r = new double[3];
    double[] v = new double[3];