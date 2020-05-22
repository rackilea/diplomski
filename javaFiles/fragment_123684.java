public static void main(String[] args) {
    String A = "caagccacctacatca";
    String B = "cgagccatccgtaaagttg";
    String C = "agaacctgctaaatgctaga";

    int iA = 0;
    int iB = 0;
    int iC = 0;

    char[] a = A.toCharArray();
    char[] b = B.toCharArray();
    char[] c = C.toCharArray();


    StringBuilder sb = new StringBuilder();

    while (iA < a.length || iB < b.length || iC < c.length) {
        if (iA < a.length && iB < b.length && iC < c.length && (a[iA] == b[iB]) && (a[iA] == c[iC])) {
            sb.append(a[iA]);
            iA++;
            iB++;
            iC++;
        }
        else if (iA < a.length && iB < b.length && a[iA] == b[iB]) {
            sb.append(a[iA]);
            iA++;
            iB++;
        }
        else if (iA < a.length && iC < c.length && a[iA] == c[iC]) {
            sb.append(a[iA]);
            iA++;
            iC++;
        }
        else if (iB < b.length && iC < c.length && b[iB] == c[iC]) {
            sb.append(b[iB]);
            iB++;
            iC++;
        } else {
            if (iC < c.length) {
                sb.append(c[iC]);
                iC++;
            }
            else if (iB < b.length) {
                sb.append(b[iB]);
                iB++;
            } else if (iA < a.length) {
                sb.append(a[iA]);
                iA++;
            }
        }
    }
    System.out.println("SUPERSEQUENCE " + sb.toString());
}