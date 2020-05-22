Document document = Jsoup.parse(new File("d:/bla.html"), "utf-8");
Elements elements = document.select(".joblisting");
for (Element element : elements) {
    Elements jobTitleElement = element.select(".job_title span");
    Elements companyNameElement = element.select(".company_name spanspan[itemprop=name]");
    String companyName = companyNameElement.text();
    String jobTitle = jobTitleElement.text();

    System.out.println(companyName);
    System.out.println(jobTitle);
}