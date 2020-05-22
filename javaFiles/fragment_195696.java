int payload = (int) ls.get(i).data;
bw.write(payload);
System.out.println("Written out " + payload);
// Or,
// System.out.println("Written out " + ((int) ls.get(i).data));
System.out.flush();