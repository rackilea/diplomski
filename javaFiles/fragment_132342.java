StringBuilder buf = new StringBuilder("http://localhost/abcdef/servlet/cpd.abcd.build.coupons.CouponValueFormatterServlet?dsn=frd_abcdef&lang=ENG&val=PRCTXT|ABCDE_-1223344&classGroupid=101,201&fgcolor=000000&bgcolor=E0DBD8&width=100&height=80&fontSize=11&fontWeight=normal.");

int start = buf.indexOf("&val=");
if (start != -1) {
    start += 5;
    int end = buf.indexOf("&", start);
    if (end == -1)
        end = buf.length();
    buf.replace(start, end, "123456");
    System.out.println(buf);
}