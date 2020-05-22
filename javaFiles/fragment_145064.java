class CashRequestModel{
      @SerializableName("orderid")
      var orderID: Int? = null
      etc.....
      @SerializableName("foods")
      var myFoods: ArrayList<OrderModel>? = null
}

class OrderMode {
     @SerializableName("userID")
     var userID: String? = null
     @SerializableName("ProductID")
     var userID: String? = null
     etc..
}