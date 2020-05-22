Set<Pair> ps = new HashSet<Pair>();
for(int ee=0;ee<sel_person.getRoles().size();ee++){
    Pair p1 = new Pair(sel_person.getRoles().get(ee).getId1Root(), sel_person.getRoles().get(ee).getId1Extension());
    ps.add(p1);
    Pair p2 = new Pair(sel_person.getRoles().get(ee).getId2Root(), sel_person.getRoles().get(ee).getId2Extension());
    ps.add(p2);
}
//now ps has only unique pairs as defined by the Pair class hashcode/equals