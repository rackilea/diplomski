Collection<Element> currencies = cube.select("Rate");

// write out
File mf = new File("2012-12-18.dat");
DataOutputStream dos = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream(mf)));
dos.writeInt(currencies.size()); // so you know how many to read.
for (Element currency : currencies) {
    MyMoney newCurrency = new MyMoney(currency);
    newCurrency.writeTo(dos);
}
dos.close();

// read in
DataInputStream dis = new DataInputStream(
        new BufferedInputStream(new FileInputStream(mf)));
int count = dis.readInt();
List<MyMoney> myMoneys = new ArrayList<>();
for (int i = 0; i < count; i++)
    myMoneys.add(new MyMoney(dis));
dis.close();

public class MyMoney {
    private final String symbol; // this is a currency
    private final BigDecimal value;

    public MyMoney(Element element) {
        this(element.attr("currency"), new BigDecimal(element.text()));
    }

    public MyMoney(DataInputStream dis) throws IOException {
        symbol = dis.readUTF();
        value = new BigDecimal(dis.readUTF());
    }

    public MyMoney(String symbol, BigDecimal value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String toString() {
        return symbol + " " + value;
    }

    public void writeTo(DataOutputStream dos) throws IOException {
        dos.writeUTF(symbol);
        dos.writeUTF(value.toString());
    }
}