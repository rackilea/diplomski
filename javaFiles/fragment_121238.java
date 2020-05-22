public class TestHandler implements test.Iface {
  public Random rnd = new Random();
  public static List<Cell> p = new ArrayList<Cell>();

  public void test() {
    for (int i = 0; i < 10000; i++) {
        Cell a = new Cell();
        a.did = "SomeString";
        a.l_x = rnd.nextDouble()*10+1;
        a.l_y = rnd.nextDouble()*10+1;
        a.l_z = 0.0;
        a.m_x = 0.0;
        a.m_y = 0.0;
        a.m_z = 0.0;
        a.a_x = 0.0;
        a.a_y = 0.0;
        a.a_z = 0.0;
        a.g_x = 0.0;
        a.g_y = 0.0;
        a.g_z = 0.0;
        a.d_t = "String here";
        a.tp = 0.0;
        a.r_q = 0.0;
        a.o_m = "A";
        a.b_v = 0.0;
        p.add(a);
    }
}
@Override
public List<Cell> number(short req) throws TException {
    test();
    return ips.ReminderBeep.list_d;
}