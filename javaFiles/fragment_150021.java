try {
                response = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(10000)
                        .execute();
                success = true;
                break;
            } catch (SocketTimeoutExceptione) {
                success = false;
            System.out.println("Timeout occured");
            }