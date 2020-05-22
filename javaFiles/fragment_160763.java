try {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json");
        ObjectMapper objectMapper = new ObjectMapper();
        currencyListArrayList = objectMapper.readValue(handleRESTApiCall(url), new TypeReference<ArrayList<CurrencyList>>() {
        });

    } catch (IOException e) {
        e.printStackTrace();
    }
    return currencyListArrayList;
}

public String handleRESTApiCall(URL url) {
    try {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String jsonOutput = bufferedReader.readLine();

        httpURLConnection.disconnect();
        return jsonOutput;

    } catch (IOException e) {
        e.printStackTrace();
    }
    return "";
}