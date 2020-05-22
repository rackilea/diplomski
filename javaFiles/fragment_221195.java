public static void main(String[] args) throws Exception { a(); }
private static void a() { b(); }
private static void b() { c(); }
private static void c() { d(); }
private static void d() { try { e(); } catch (Exception e) { throw new RuntimeException(e); } }
private static void e() { f(); }
private static void f() { g(); }
private static void g() { try { h(); } catch (Exception e) { throw new IllegalStateException(e); } }
private static void h() { i(); }
private static void i() { j(); }
private static void j() { throw new UnsupportedOperationException("Test"); }