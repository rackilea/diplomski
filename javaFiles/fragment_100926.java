String url = "http://www.bestbuy.ca/en-CA/product/samsung-samsung-galaxy-tab-3-8-0-16gb-android-4-2-tablet-with-exynos-4212-processor-white-sm-t310/10254746.aspx?path=8654a6d491c7d5a9465456671fa126e4en02";
Document document = Jsoup.connect(url).get();

String amount = document.select(".amount").first().text();
System.out.println("Price: " + amount);

String name = document.select(".product-title").first().text();
System.out.println("Item Name: " + name);