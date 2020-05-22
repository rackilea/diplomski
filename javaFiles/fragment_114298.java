object Parser {

var result = HashMap<String, String>()

fun parseJsonObject(url: String, method: String, params: List<NameValuePair>): HashMap<String, String> {
    var url = url
    var iStream: InputStream ?= null
    var data = ""

    println("url*************" + url)
    println("params*************" + params)

    var httpClient: DefaultHttpClient? = null
    try {

        // check for request method
        if (method === "POST") {
            // request method is POST
            // defaultHttpClient
            if (httpClient == null) {

                httpClient = DefaultHttpClient()
            }

            val httpPost = HttpPost(url)
            httpPost.entity = UrlEncodedFormEntity(params)

            // set timeout
            HttpConnectionParams.setConnectionTimeout(httpClient.params, 20000)
            HttpConnectionParams.setSoTimeout(httpClient.params, 30000)

            val httpResponse = httpClient.execute(httpPost)

            if (httpResponse.statusLine.statusCode === 200) {
                val httpEntity = httpResponse.entity
                iStream = httpEntity.content
                val br = BufferedReader(
                        InputStreamReader(iStream!!, "utf8"))
                val sb = StringBuffer()
                var line = ""
                while ((line == br.readLine()) != null) {
                    sb.append(line)
                }
                data = sb.toString()
                br.close()
                iStream.close()
                httpClient.connectionManager.closeExpiredConnections()
                result.put("code", "200")
                result.put("value", data)
            } else {
                httpClient.connectionManager.closeExpiredConnections()
                result.put("code", "9999")
                result.put("value", "")
            }

        } else if (method === "GET") {
            // request method is GET
            if (httpClient == null) {
                httpClient = DefaultHttpClient()
            }
            val paramString = URLEncodedUtils.format(params, "utf-8")
            url += "?" + paramString
            val httpGet = HttpGet(url)

            // set timeout
            HttpConnectionParams.setConnectionTimeout(httpClient.params, 20000)
            HttpConnectionParams.setSoTimeout(httpClient.params, 30000)

            val httpResponse = httpClient.execute(httpGet)

            if (httpResponse.statusLine.statusCode === 200) {
                val httpEntity = httpResponse.entity
                iStream = httpEntity.content
                val br = BufferedReader(
                        InputStreamReader(iStream!!, "utf8"))
                val sb = StringBuffer()
                var line = ""
                while ((line == br.readLine()) != null) {
                    sb.append(line)
                }
                data = sb.toString()
                br.close()
                iStream.close()
                httpClient.connectionManager.closeExpiredConnections()
                result.put("code", "200")
                result.put("value", data)
            } else {
                httpClient.connectionManager.closeExpiredConnections()
                result.put("code", "9999")
                result.put("value", "")
            }

        }

    } catch (e: Exception) {
        result.put("code", "9999")
        result.put("value", "")
        e.printStackTrace()
        return result
    }

    return result
}