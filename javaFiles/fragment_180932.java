List<String> urls = Arrays.asList("http://host.com/api/person/1234", "http://host.com/api/person/1234/jobs", "http://host.com/api/person/1234/jobs/321", "http://host.com/api/person/abc1234/jobs", "http://host.com/api/person/1234abc/jobs");
for (int i = 0; i < urls.size(); i++) {
   urls.set(i, urls.get(i).replaceAll("(?<=/)\\d+(?=/|$)", "#####"));
}
System.out.println(urls.toString());

// Result:
// [http://host.com/api/person/#####, http://host.com/api/person/#####/jobs, http://host.com/api/person/#####/jobs/#####, http://host.com/api/person/abc1234/jobs, host.com/api/person/1234abc/jobs]