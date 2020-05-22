URL url = new URL("http://www.annualreports.co.uk/HostedData/AnnualReports/PDF/LSE_" + entry[0] + "_2015.pdf");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.addRequestProperty("User-Agent", "Mozilla/4.76");
int size = conn.getContentLength();

        if (size < 0) {
            System.out.println("File not found");
        } else {
            System.out.println("File size in Bytes: " + size);
        }