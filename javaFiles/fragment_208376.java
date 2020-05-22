public class CountryProvider {

     @Autowired HbnCountryDao dao;
     Map<String, Country> map = new HashMap<String, Country>();

     public Country getByCode(String code) {
         if (map.contains(code)) return map.get(code);
         Country toRet = dao.getByCode(code);
         map.put(code, toRet);
         return toRet;
     }
}