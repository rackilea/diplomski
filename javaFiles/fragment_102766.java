@RequestMapping(value="/availability", method=RequestMethod.POST)
public @ResponseBody JsonResponse emailAvailability(String email) {
    JsonResponse res = new JsonResponse();
    boolean a = true;
    Query q = new Query("UserDetailsNew");
    PreparedQuery pq = ds.prepare(q);

    System.out.println("email in availability : " + email);

    for (Entity e : pq.asIterable()) {
        String Email = (String) e.getProperty("Email");
        if (Email.equals(email)) {
            a = false;
            return a;
        }
    }
     res.setStatus("success");
     res.setResult(a);
     return res;

}