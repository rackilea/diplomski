public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        Map<String, String> priceData = new HashMap<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        String orderId = null;
        String orderPrice = null;

        try {
            String sCurrentLine = null;

            Object obj = parser.parse(new FileReader(
                    "orders.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray orderList = (JSONArray)(jsonObject.get("orders"));
            System.out.println("Complete order list --"+orderList.toString());

            for(Object singleOrder : orderList) {
                JSONObject singleArrayData = (JSONObject) singleOrder;
                orderId = singleArrayData.get("id").toString();
                orderPrice = singleArrayData.get("total_price").toString();
                priceData.put(orderId, orderPrice);
                totalPrice = totalPrice.add(new BigDecimal(orderPrice));
            }
            System.out.println("The price data of each order --"+priceData.toString());
            System.out.println("The total Price of all order --"+totalPrice);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }