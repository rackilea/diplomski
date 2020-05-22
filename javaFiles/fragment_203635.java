HashSet<HashMap> hs = new HashSet<HashMap>();
HashMap<String, String> hm1 = new HashMap<String, String>();
hm1.put("name", "Amit");
hm1.put("device_id", "192.168.1.100");
hm1.put("ip", "192.168.1.100");

hs.add(hm1);

HashMap<String, String> hm2 = new HashMap<String, String>();
hm2.put("name", "Mani");
hm2.put("device_id", "192.168.1.102");
hm2.put("ip", "192.168.1.102");

hs.add(hm2);