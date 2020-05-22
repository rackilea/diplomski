fun selectType(callback:(Int) -> Unit) {
val url= "http://mydomen/getallcars.php"

val pd= ProgressDialog(this)
pd.setMessage("Please Wait...")
pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
pd.show()

val rq= Volley.newRequestQueue(this)
val sr= StringRequest(
    Request.Method.GET, url,
    Response.Listener { response ->
        pd.hide()

        //converting the string to json array object
        val array = JSONArray(response)

        list.clear()

        //traversing through all the object
        var n1 = 0
        for (i in 0 until array.length()) {

            //getting item object from json array
            val product = array.getJSONObject(i)

            Log.d("testing123", product.toString())
            //adding the product to item list

            if(product.getString("type") == fandvtext.text.toString()) {
                n1=+1

                Log.d("counter1", n1.toString())

            }

            list.add(
                Cars(
                    product.getString("type")
                )
            )
        }
      callback.invoke(n1)
    },