XMLPackager packager = new XMLPackager();
XMLChannel channel = new XMLChannel("localhost", 11000, packager);

channel.setPackager(packager);
channel.setTimeout(30000);
channel.connect();

Date now = new Date();
ISOMsg m = new ISOMsg();

m.setMTI("2100");
m.set("3", "000000");
m.set(new ISOAmount(4, 840, new BigDecimal(10.00)));
m.set("7", ISODate.formatDate(now, "MMddHHmmss"));
m.set("11", "1111");
m.set("12", ISODate.formatDate(now, "yyyyMMddHHmmss"));
m.set("22", "KEY.UNK.ECO.APP");
m.set("26", "5999");
m.set("27", "00100000000000001000000000000000");
m.set("32", "00000000001");
m.set("41", "59991515");
m.set("42", "888000003518");
m.set("43.2", "Shegda Electronics");
m.set("43.4", "Richardson");
m.set("43.5", "TX");
m.set("43.6", "63105");
m.set("43.7", "USA");
m.set("49.1", "1");
m.set("49.3", "121 First Street");
m.set("49.4", "85284");
m.set("104.4", "1");

channel.send(m);
ISOMsg resp = channel.receive();