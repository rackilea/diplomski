UserAdmin ua = new UserAdmin();
Wafat w = new Wafat();
w.setKode_wafat("Kode_Wafat");
ua.setWafat(w);
w.setUseradmin(ua);
session.persist(ua);